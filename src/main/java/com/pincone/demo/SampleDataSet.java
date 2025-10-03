package com.pincone.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SampleDataSet {
    public static ArrayList<Map<String, String>> prepareDataSet(){
        // Add to the Quickstart class:
        ArrayList<Map<String, String>> upsertRecords = new ArrayList<>();

        HashMap<String, String> record1 = new HashMap<>();
        record1.put("_id", "rec1");
        record1.put("chunk_text", "The Eiffel Tower was completed in 1889 and stands in Paris, France.");
        record1.put("category", "history");

        HashMap<String, String> record2 = new HashMap<>();
        record2.put("_id", "rec2");
        record2.put("chunk_text", "Photosynthesis allows plants to convert sunlight into energy.");
        record2.put("category", "science");

        HashMap<String, String> record3 = new HashMap<>();
        record3.put("_id", "rec3");
        record3.put("chunk_text", "Albert Einstein developed the theory of relativity.");
        record3.put("category", "science");

        HashMap<String, String> record4 = new HashMap<>();
        record4.put("_id", "rec4");
        record4.put("chunk_text", "The mitochondrion is often called the powerhouse of the cell.");
        record4.put("category", "biology");

        HashMap<String, String> record5 = new HashMap<>();
        record5.put("_id", "rec5");
        record5.put("chunk_text", "Shakespeare wrote many famous plays, including Hamlet and Macbeth.");
        record5.put("category", "literature");

        HashMap<String, String> record6 = new HashMap<>();
        record6.put("_id", "rec6");
        record6.put("chunk_text", "Water boils at 100°C under standard atmospheric pressure.");
        record6.put("category", "physics");

        HashMap<String, String> record7 = new HashMap<>();
        record7.put("_id", "rec7");
        record7.put("chunk_text", "The Great Wall of China was built to protect against invasions.");
        record7.put("category", "history");

        HashMap<String, String> record8 = new HashMap<>();
        record8.put("_id", "rec8");
        record8.put("chunk_text", "Honey never spoils due to its low moisture content and acidity.");
        record8.put("category", "food science");

        HashMap<String, String> record9 = new HashMap<>();
        record9.put("_id", "rec9");
        record9.put("chunk_text", "The speed of light in a vacuum is approximately 299,792 km/s.");
        record9.put("category", "physics");

        HashMap<String, String> record10 = new HashMap<>();
        record10.put("_id", "rec10");
        record10.put("chunk_text", "Newton's laws describe the motion of objects.");
        record10.put("category", "physics");

        HashMap<String, String> record11 = new HashMap<>();
        record11.put("_id", "rec11");
        record11.put("chunk_text", "The human brain has approximately 86 billion neurons.");
        record11.put("category", "biology");

        HashMap<String, String> record12 = new HashMap<>();
        record12.put("_id", "rec12");
        record12.put("chunk_text", "The Amazon Rainforest is one of the most biodiverse places on Earth.");
        record12.put("category", "geography");

        HashMap<String, String> record13 = new HashMap<>();
        record13.put("_id", "rec13");
        record13.put("chunk_text", "Black holes have gravitational fields so strong that not even light can escape.");
        record13.put("category", "astronomy");

        HashMap<String, String> record14 = new HashMap<>();
        record14.put("_id", "rec14");
        record14.put("chunk_text", "The periodic table organizes elements based on their atomic number.");
        record14.put("category", "chemistry");

        HashMap<String, String> record15 = new HashMap<>();
        record15.put("_id", "rec15");
        record15.put("chunk_text", "Leonardo da Vinci painted the Mona Lisa.");
        record15.put("category", "art");

        HashMap<String, String> record16 = new HashMap<>();
        record16.put("_id", "rec16");
        record16.put("chunk_text", "The internet revolutionized communication and information sharing.");
        record16.put("category", "technology");

        HashMap<String, String> record17 = new HashMap<>();
        record17.put("_id", "rec17");
        record17.put("chunk_text", "The Pyramids of Giza are among the Seven Wonders of the Ancient World.");
        record17.put("category", "history");

        HashMap<String, String> record18 = new HashMap<>();
        record18.put("_id", "rec18");
        record18.put("chunk_text", "Dogs have an incredible sense of smell, much stronger than humans.");
        record18.put("category", "biology");

        HashMap<String, String> record19 = new HashMap<>();
        record19.put("_id", "rec19");
        record19.put("chunk_text", "The Pacific Ocean is the largest and deepest ocean on Earth.");
        record19.put("category", "geography");

        HashMap<String, String> record20 = new HashMap<>();
        record20.put("_id", "rec20");
        record20.put("chunk_text", "Chess is a strategic game that originated in India.");
        record20.put("category", "games");

        HashMap<String, String> record21 = new HashMap<>();
        record21.put("_id", "rec21");
        record21.put("chunk_text", "The Statue of Liberty was a gift from France to the United States.");
        record21.put("category", "history");

        HashMap<String, String> record22 = new HashMap<>();
        record22.put("_id", "rec22");
        record22.put("chunk_text", "Coffee contains caffeine, a natural stimulant.");
        record22.put("category", "food science");

        HashMap<String, String> record23 = new HashMap<>();
        record23.put("_id", "rec23");
        record23.put("chunk_text", "Thomas Edison invented the practical electric light bulb.");
        record23.put("category", "inventions");

        HashMap<String, String> record24 = new HashMap<>();
        record24.put("_id", "rec24");
        record24.put("chunk_text", "The moon influences ocean tides due to gravitational pull.");
        record24.put("category", "astronomy");

        HashMap<String, String> record25 = new HashMap<>();
        record25.put("_id", "rec25");
        record25.put("chunk_text", "DNA carries genetic information for all living organisms.");
        record25.put("category", "biology");

        HashMap<String, String> record26 = new HashMap<>();
        record26.put("_id", "rec26");
        record26.put("chunk_text", "Rome was once the center of a vast empire.");
        record26.put("category", "history");

        HashMap<String, String> record27 = new HashMap<>();
        record27.put("_id", "rec27");
        record27.put("chunk_text", "The Wright brothers pioneered human flight in 1903.");
        record27.put("category", "inventions");

        HashMap<String, String> record28 = new HashMap<>();
        record28.put("_id", "rec28");
        record28.put("chunk_text", "Bananas are a good source of potassium.");
        record28.put("category", "nutrition");

        HashMap<String, String> record29 = new HashMap<>();
        record29.put("_id", "rec29");
        record29.put("chunk_text", "The stock market fluctuates based on supply and demand.");
        record29.put("category", "economics");

        HashMap<String, String> record30 = new HashMap<>();
        record30.put("_id", "rec30");
        record30.put("chunk_text", "A compass needle points toward the magnetic north pole.");
        record30.put("category", "navigation");

        HashMap<String, String> record31 = new HashMap<>();
        record31.put("_id", "rec31");
        record31.put("chunk_text", "The universe is expanding, according to the Big Bang theory.");
        record31.put("category", "astronomy");

        HashMap<String, String> record32 = new HashMap<>();
        record32.put("_id", "rec32");
        record32.put("chunk_text", "Elephants have excellent memory and strong social bonds.");
        record32.put("category", "biology");

        HashMap<String, String> record33 = new HashMap<>();
        record33.put("_id", "rec33");
        record33.put("chunk_text", "The violin is a string instrument commonly used in orchestras.");
        record33.put("category", "music");

        HashMap<String, String> record34 = new HashMap<>();
        record34.put("_id", "rec34");
        record34.put("chunk_text", "The heart pumps blood throughout the human body.");
        record34.put("category", "biology");

        HashMap<String, String> record35 = new HashMap<>();
        record35.put("_id", "rec35");
        record35.put("chunk_text", "Ice cream melts when exposed to heat.");
        record35.put("category", "food science");

        HashMap<String, String> record36 = new HashMap<>();
        record36.put("_id", "rec36");
        record36.put("chunk_text", "Solar panels convert sunlight into electricity.");
        record36.put("category", "technology");

        HashMap<String, String> record37 = new HashMap<>();
        record37.put("_id", "rec37");
        record37.put("chunk_text", "The French Revolution began in 1789.");
        record37.put("category", "history");

        HashMap<String, String> record38 = new HashMap<>();
        record38.put("_id", "rec38");
        record38.put("chunk_text", "The Taj Mahal is a mausoleum built by Emperor Shah Jahan.");
        record38.put("category", "history");

        HashMap<String, String> record39 = new HashMap<>();
        record39.put("_id", "rec39");
        record39.put("chunk_text", "Rainbows are caused by light refracting through water droplets.");
        record39.put("category", "physics");

        HashMap<String, String> record40 = new HashMap<>();
        record40.put("_id", "rec40");
        record40.put("chunk_text", "Mount Everest is the tallest mountain in the world.");
        record40.put("category", "geography");

        HashMap<String, String> record41 = new HashMap<>();
        record41.put("_id", "rec41");
        record41.put("chunk_text", "Octopuses are highly intelligent marine creatures.");
        record41.put("category", "biology");

        HashMap<String, String> record42 = new HashMap<>();
        record42.put("_id", "rec42");
        record42.put("chunk_text", "The speed of sound is around 343 meters per second in air.");
        record42.put("category", "physics");

        HashMap<String, String> record43 = new HashMap<>();
        record43.put("_id", "rec43");
        record43.put("chunk_text", "Gravity keeps planets in orbit around the sun.");
        record43.put("category", "astronomy");

        HashMap<String, String> record44 = new HashMap<>();
        record44.put("_id", "rec44");
        record44.put("chunk_text", "The Mediterranean diet is considered one of the healthiest in the world.");
        record44.put("category", "nutrition");

        HashMap<String, String> record45 = new HashMap<>();
        record45.put("_id", "rec45");
        record45.put("chunk_text", "A haiku is a traditional Japanese poem with a 5-7-5 syllable structure.");
        record45.put("category", "literature");

        HashMap<String, String> record46 = new HashMap<>();
        record46.put("_id", "rec46");
        record46.put("chunk_text", "The human body is made up of about 60% water.");
        record46.put("category", "biology");

        HashMap<String, String> record47 = new HashMap<>();
        record47.put("_id", "rec47");
        record47.put("chunk_text", "The Industrial Revolution transformed manufacturing and transportation.");
        record47.put("category", "history");

        HashMap<String, String> record48 = new HashMap<>();
        record48.put("_id", "rec48");
        record48.put("chunk_text", "Vincent van Gogh painted Starry Night.");
        record48.put("category", "art");

        HashMap<String, String> record49 = new HashMap<>();
        record49.put("_id", "rec49");
        record49.put("chunk_text", "Airplanes fly due to the principles of lift and aerodynamics.");
        record49.put("category", "physics");

        HashMap<String, String> record50 = new HashMap<>();
        record50.put("_id", "rec50");
        record50.put("chunk_text", "Renewable energy sources include wind, solar, and hydroelectric power.");
        record50.put("category", "energy");

        upsertRecords.add(record1);
        upsertRecords.add(record2);
        upsertRecords.add(record3);
        upsertRecords.add(record4);
        upsertRecords.add(record5);
        upsertRecords.add(record6);
        upsertRecords.add(record7);
        upsertRecords.add(record8);
        upsertRecords.add(record9);
        upsertRecords.add(record10);
        upsertRecords.add(record11);
        upsertRecords.add(record12);
        upsertRecords.add(record13);
        upsertRecords.add(record14);
        upsertRecords.add(record15);
        upsertRecords.add(record16);
        upsertRecords.add(record17);
        upsertRecords.add(record18);
        upsertRecords.add(record19);
        upsertRecords.add(record20);
        upsertRecords.add(record21);
        upsertRecords.add(record22);
        upsertRecords.add(record23);
        upsertRecords.add(record24);
        upsertRecords.add(record25);
        upsertRecords.add(record26);
        upsertRecords.add(record27);
        upsertRecords.add(record28);
        upsertRecords.add(record29);
        upsertRecords.add(record30);
        upsertRecords.add(record31);
        upsertRecords.add(record32);
        upsertRecords.add(record33);
        upsertRecords.add(record34);
        upsertRecords.add(record35);
        upsertRecords.add(record36);
        upsertRecords.add(record37);
        upsertRecords.add(record38);
        upsertRecords.add(record39);
        upsertRecords.add(record40);
        upsertRecords.add(record41);
        upsertRecords.add(record42);
        upsertRecords.add(record43);
        upsertRecords.add(record44);
        upsertRecords.add(record45);
        upsertRecords.add(record46);
        upsertRecords.add(record47);
        upsertRecords.add(record48);
        upsertRecords.add(record49);
        upsertRecords.add(record50);
        return upsertRecords;
    }
}
