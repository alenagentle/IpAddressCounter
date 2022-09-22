public class Ip implements Comparable<Ip> {
    String ip;
    long hashCode;
    long position;
    long count = 1;

    public Ip(String ip, long position) {
        this.ip = ip;
        this.position = position;
        calcIpHashCode();
    }

    private void calcIpHashCode() {
        final String[] split = ip.split("\\.");
        for (String s : split) {
            hashCode = 31 * hashCode + s.hashCode();
        }
    }

    public String getIp() {
        return ip;
    }

    public long getHashCode() {
        return hashCode;
    }

    public long getPosition() {
        return position;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Ip = " + ip;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        else if (this.hashCode == ((Ip) obj).getHashCode())
            return true;
        else return this.ip.equals(((Ip) obj).getIp());
    }

    @Override
    public int compareTo(Ip ip) {
        if (this.hashCode < ip.getHashCode()) {
            return -1;
        } else if (this.hashCode > ip.getHashCode())
            return +1;
        return 0;
    }
}
