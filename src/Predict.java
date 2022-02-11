import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Predict  implements Command{
    private static class Word {
        private final String word;
        private final Map<String, Integer> occurences = new HashMap<>();

        public Word(String word) {
            this.word = word;
        }

        public void putFollower(String w) {
            this.occurences.put(w, this.occurences.getOrDefault(w, 0) + 1);
        }

        public String predict() {
            if (occurences.isEmpty())
                return null;

            var i = Collections.max(occurences.values());

            var list = this.occurences.keySet().stream().filter(k -> occurences.get(k).equals(i)).toList();

            return list.get(0);
        }
    }

    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a filename:");
        String content;
        try {
            content = Files.readString(Path.of(scanner.nextLine()));
        } catch (Exception e) {
            System.err.println("Unreadable file: " + e.getMessage());
            return false;
        }

        content = content.toLowerCase()
                .replaceAll("[.!?\\-'\"\t\n]", " ")
                .replaceAll(" {2}", " ");

        if (content.isBlank())
            return false;

        Map<String, Word> words = new HashMap<>();
        var lastWord = Arrays.stream(content.split(" "))
                .filter(s -> !s.isBlank())
                .reduce("", (prev, next) -> {
                    if (!prev.isBlank()) {
                        words.putIfAbsent(prev, new Word(prev));
                        words.get(prev).putFollower(next);
                    }
                    return next;
                });

        words.putIfAbsent(lastWord, new Word(lastWord));

        System.out.println("Enter a word :");
        var startWord = scanner.nextLine().toLowerCase();

        if (!words.containsKey(startWord))
            System.err.println("Word not found in the text!");

        else {
            var sentence = new ArrayList<>(List.of(startWord));
            while (sentence.size() < 20) {
                var nextWord = words.get(sentence.get(sentence.size() - 1)).predict();
                if (nextWord == null)
                    break;
                sentence.add(nextWord);
            }

            System.out.println(String.join(" ", sentence));
        }


        return false;
    }
}

