public class Codec {
    HashMap<String, String> hashMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String res = Integer.toHexString(longUrl.hashCode());
        hashMap.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
