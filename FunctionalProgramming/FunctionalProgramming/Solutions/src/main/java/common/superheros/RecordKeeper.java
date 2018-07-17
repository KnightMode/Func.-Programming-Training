package common.superheros;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordKeeper {

    private Record.Builder currentFight;
    private Map<String, List<Record>> records = new HashMap<>();

    public void startRecording(Pair<SuperHero,SuperHero> heroes) {
        currentFight = new Record.Builder()
                                    .init(heroes.getValue0(), heroes.getValue1());

    }

    public void stopRecording(Pair<SuperHero,SuperHero> fightResult) {
        Record fightRecord = currentFight.end(fightResult.getValue0(), fightResult.getValue1());
        appendToRecord(fightRecord);
        appendToRecord(fightRecord.invert());
    }

    private void appendToRecord(Record fightRecord) {
        String heroName = fightRecord.heroName();
        List<Record> list = records.get(heroName);
        if(list == null)
            list = new ArrayList<>();
        list.add(fightRecord);
        records.put(heroName, list);
    }

    public List<String> historyOf(String name) {
        List<Record> heroRecords = records.get(name);
        List<String> results = new ArrayList<>();
        for(Record record: heroRecords){
            results.add(record.toString());
        }
        return results;
    }
}
