import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface Observer<T> {
    void onNext(T t);

    void onError(Throwable t);

    void onComplete();
}

@FunctionalInterface
interface Subscription {
    void unsubscribe();
}

@FunctionalInterface
interface Observable<T> {
    Subscription subscribe(Observer<T> observer);

    static <T> Observable<T> from(List<T> t) {
        return new DataSource<T>(t);
    }

    static <T> Observable<T> unsafeCreate(Consumer<Observer<T>> block) {
        return observer -> {
            Subscription s = () -> {
            };
            block.accept(observer);
            return s;
        };
    }

    static <T> Observable<T> just(T t) {
        return Observable.unsafeCreate(observer -> {
            observer.onNext(t);
            observer.onComplete();
        });
    }

    default Observable<T> filter(Predicate<T> fn) {
        return observer -> {
            Observer<T> obsT = new Observer<T>() {
                @Override
                public void onNext(T t) {
                    if (fn.test(t))
                        observer.onNext(t);
                }

                @Override
                public void onError(Throwable t) {
                    observer.onError(t);
                }

                @Override
                public void onComplete() {
                    observer.onComplete();
                }
            };
            return this.subscribe(obsT);
        };
    }

    default <R> Observable<R> map(Function<T, R> fn) {
        return observer -> {
            Observer<T> obsT = new Observer<T>() {
                @Override
                public void onNext(T t) {
                    R r = fn.apply(t);
                    observer.onNext(r);
                }

                @Override
                public void onError(Throwable t) {
                    observer.onError(t);
                }

                @Override
                public void onComplete() {
                    observer.onComplete();
                }
            };
            return this.subscribe(obsT);
        };
    }

    //If types are not matching

    class DataSource<T> implements Observable<T> {
        private List<T> integerList;
        private Boolean cancel = false;

        public DataSource(List<T> list) {
            this.integerList = list;
        }

        public Subscription subscribe(Observer<T> observer) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            //submit job to the executor
            executorService.submit(() -> {
                        for (T element : integerList) {
                            try {
                                Thread.sleep(500);
                                observer.onNext(element);
                                //throw new RuntimeException("err");
                            } catch (InterruptedException e) {
                                cancel = true;
                                observer.onError(e);
                            }
                        }
                        if (!cancel)
                            observer.onComplete();
                    }
            );
            return () -> {
                try {
                    executorService.shutdown();
                    executorService.awaitTermination(10, TimeUnit.SECONDS);
                } catch (Exception e) {
                }
                System.out.println("Unsubscribing");
                cancel = true;
            };
        }
    }
}

class RecordsObserver implements Observer<Integer> {

    @Override
    public void onNext(Integer integer) {
        //if (integer == 3)
        //  throw new RuntimeException("on purpose");
        System.out.println("onNext =>" + integer);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Error");
    }

    @Override
    public void onComplete() {
        System.out.println("****Emission Completed****");
    }
}

public class Obs {
    public static void main(String[] args) {
        //Observable<Integer> ds = Observable.from(Arrays.asList(1, 3, 4, 5));
        //Observable<Integer> tObservable = Observable.unsafeCreate(observer -> observer.onNext(2));
        Observable<Integer> justOne = Observable.just(11).map(x -> x * 2).filter(x -> x % 2 != 0);
        //Subscription subscription1 =
        RecordsObserver ro = new RecordsObserver();

        //Subscription subscription = justOne.subscribe(ro);
        justOne.subscribe(ro);
        //subscription.unsubscribe();
    }
}
