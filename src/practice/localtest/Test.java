package practice.localtest;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Test {

  public static void main(String[] args) throws URISyntaxException {
    String input = "/drives/b!JxaBb7wahU-LQth0njaPq6lukBqywcJDp7i6ezGKYTUn1amgQpnFR6z56yN-dr21/root:";
    String inputWithFolder = "/drives/b!JxaBb7wahU-LQth0njaPq6lukBqywcJDp7i6ezGKYTUn1amgQpnFR6z56yN-dr21/root:/Fold-1";
    String text = "/sites/Communication Site/subsite11/NestedSubsite11-1/NestedSubsite11-2/";
    String [] pathSplit = input.split(":");
    String [] pathSplit2 = inputWithFolder.split(":");
    String path = "";
    if(pathSplit.length > 1) {
      path = text + ":" + pathSplit[1];
    } else if(pathSplit.length == 1){
      path = text + ":";
    }
    System.out.println(path);

    String originalString = "admin@skyhighcsm1.onmicrosoft.com";

    // Replace all occurrences of '.' and '@' with '_'
    // The '.' needs to be escaped with '\\' because it's a special character in regex.
    // The '|' acts as an OR operator in regex, matching either '.' or '@'.
    String modifiedString = originalString.replaceAll("[.@]", "_");

    System.out.println("Original String: " + originalString);
    System.out.println("Modified String: " + modifiedString);

    //url decoding

    String encodedString = "/Shared%20Documents";
    String decodedWithUtf8 = URLDecoder.decode(encodedString, StandardCharsets.UTF_8);
    System.out.println(decodedWithUtf8);
    String decodedWithISO_8859_1 = URLDecoder.decode(encodedString, StandardCharsets.ISO_8859_1);
    System.out.println(decodedWithISO_8859_1);

    String urlWithoutSlash = "https://skyhighcsm1-my.sharepoint.com";
    String urlWithSlash = "https://skyhighcsm1-my.sharepoint.com/";
    System.out.println(removeTrailingSlash(urlWithSlash));
    System.out.println(removeTrailingSlash(urlWithoutSlash));
    String[] url = {"https://skyhighcsm1.sharepoint.com/subsite11/NestedSubsite11-1/NestedSubsite11-2/_layouts/15/Doc.aspx?sourcedoc=%7BB81B2C0D-4F02-45C7-88EF-6AA04BF92700%7D&file=SPLASH_TEST_UPLOADED.docx&action=default&mobileredirect=true",
                    "https://skyhighcsm1.sharepoint.com/subsite11/NestedSubsite11-1/NestedSubsite11-2/NestedSubsite112doclib/Fold-1",
                    "https://skyhighcsm1.sharepoint.com/sites/groupoffice3651758041135.731655/Shared%20Documents",
      "https://skyhighcsm1.sharepoint.com/subsite11/subsite11%20doc%20lib",
        "https://spaces.aexp.com/teams/RSAReporting/_api/Web/GetFileByServerRelativePath",
        "https://spaces.aexp.au/teams/RSAReporting/_api/Web/GetFileByServerRelativePath"}

      ;

    getURL(Arrays.asList(url));
  }

  private static void getURL(List<String> urlList) throws URISyntaxException {
    for( String url : urlList) {
      URI uri = new URI(url);
      String domainName = uri.getHost();
      System.out.println(uri.getPath().concat("/"));
      System.out.println("Original URL: " + url);
      System.out.println("Extracted Domain: " + domainName);
    }
  }

  public static String removeTrailingSlash(String str) {
    if (str != null && !str.isEmpty() && str.endsWith("/")) {
      return str.substring(0, str.length() - 1);
    }
    return str;
  }
}
