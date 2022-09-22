import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Parser {
    final private String filename;
    final static int bufferSize = 1000;

    public Parser(String filename) {
        this.filename = filename;
    }

    public void parse() {
        try (FileReader fileReader = new FileReader(filename)) {
            List<Ip> ipList;
            List<Ip> uniqIpList = new ArrayList<>();
            while (!(ipList = fileReader.readFile(bufferSize)).isEmpty()) {
                uniqIpList.addAll(ipList);
                Collections.sort(uniqIpList);
                ListIterator<Ip> ipListIterator = uniqIpList.listIterator();

                while (ipListIterator.hasNext()) {
                    Ip first = ipListIterator.next();
                    while (ipListIterator.hasNext()) {
                        Ip second = ipListIterator.next();
                        if (second.equals(first)) {
                            ipListIterator.remove();
                            first.setCount(first.getCount() + 1);
                        } else {
                            ipListIterator.previous();
                            break;
                        }
                    }
                }
            }
            uniqIpList.stream()
                    .filter(ip -> ip.getCount() == 1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
