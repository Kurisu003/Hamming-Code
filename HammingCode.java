public class CodeWars {
  public String encode(String string) {
            String finalString = "";


        for (char chars : string.toCharArray()) {
            String buffer = Integer.toBinaryString(chars);
            while (buffer.length() < 8)
                buffer = "0" + buffer;
            finalString += buffer;
        }

        return finalString.replaceAll("0", "000").replaceAll("1", "111");
  }
  public String decode(String string) {
    String finalString = "";

        for(int i = 0; i < string.length(); i += 3){

            if (string.charAt(i) != string.charAt(i + 1) || string.charAt(i) != string.charAt(i + 2)) {
                int sum = Integer.parseInt(Character.toString(string.charAt(i))) + Integer.parseInt(Character.toString(string.charAt(i + 1))) + Integer.parseInt(Character.toString(string.charAt(i + 2)));

                if (sum >= 2){
                    finalString += "1";
                }
                else{
                    finalString += "0";
                }

            }
            else{
                finalString += string.charAt(i);
            }
        }

        String str = "";

        for (int i = 0; i < finalString.length()/8; i++) {

            int a = Integer.parseInt(finalString.substring(8*i,(i+1)*8),2);
            str += (char)(a);
        }

        return str; 
  }
}