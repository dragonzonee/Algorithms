public class Codec {

    ArrayList<String> src = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        src.add(longUrl);
        return String.valueOf(src.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int idx = Integer.parseInt(shortUrl);
        return idx<src.size()? src.get(idx):"";
    }
}
