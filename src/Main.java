public class Main {

    private static final String FILE = "ips2.txt";

    public static void main(String[] args) {
        Parser uniqIpParser = new Parser(FILE);
        long startTime = System.currentTimeMillis();
        uniqIpParser.parse();
        System.out.println(System.currentTimeMillis() - startTime + "ms");
    }
}
