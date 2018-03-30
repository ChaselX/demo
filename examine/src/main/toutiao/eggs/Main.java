package toutiao.eggs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Main {

    // TODO 没有通过所有的测试数据
    static Map<Character, List<String>> MAP = new HashMap<Character, List<String>>() {{
        String[] zero = {"66666", "6...6", "6...6", "6...6", "66666"};
        String[] one = {"....6", "....6", "....6", "....6", "....6"};
        String[] two = {"66666", "....6", "66666", "6....", "66666"};
        String[] three = {"66666", "....6", "66666", "....6", "66666"};
        String[] four = {"6...6", "6...6", "66666", "....6", "....6"};
        String[] five = {"66666", "6....", "66666", "....6", "66666"};
        String[] six = {"66666", "6....", "66666", "6...6", "66666"};
        String[] seven = {"66666", "....6", "....6", "....6", "....6"};
        String[] eight = {"66666", "6...6", "66666", "6...6", "66666"};
        String[] nine = {"66666", "6...6", "66666", "....6", "66666"};
        put('0',Arrays.asList(zero));
        put('1',Arrays.asList(one));
        put('2',Arrays.asList(two));
        put('3',Arrays.asList(three));
        put('4',Arrays.asList(four));
        put('5',Arrays.asList(five));
        put('6',Arrays.asList(six));
        put('7',Arrays.asList(seven));
        put('8',Arrays.asList(eight));
        put('9',Arrays.asList(nine));
    }};

    public static void main(String[] args) throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        List<String> result = new LinkedList<>();
        Integer len = new Integer(scanner.nextLine());
        char ch;
        for (int i = 0; i < len; i++) {
            result.add( engine.eval(scanner.nextLine()).toString());
        }
        for (String tmp : result) {
            for (int i = 0; i < 5; i++) {
                StringBuilder builder = new StringBuilder("");
                for (int j = 0; j < tmp.length(); j++) {
                    ch = tmp.charAt(j);
                    builder.append(MAP.get(ch).get(i) + "..");
                }
                builder.delete(builder.length() - 2, builder.length());
                System.out.println(builder.toString());
            }
        }
    }
}
