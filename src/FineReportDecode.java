import com.seeyon.ctp.util.TextEncoder;
import com.seeyon.ctp.util.TextEncoder;

public class FineReportDecode {
    private static final int[] PASSWORD_MASK_ARRAY = { 19, 78, 10, 15, 100, 213, 43, 23 };

    private static String passwordDecode(String paramString)
    {
        if ((paramString != null) && (paramString.startsWith("___")))
        {
            paramString = paramString.substring(3);
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            for (int j = 0; j <= paramString.length() - 4; j += 4)
            {
                if (i == PASSWORD_MASK_ARRAY.length) {
                    i = 0;
                }
                String str = paramString.substring(j, j + 4);
                int k = Integer.parseInt(str, 16) ^ PASSWORD_MASK_ARRAY[i];
                localStringBuilder.append((char)k);
                i++;
            }
            paramString = localStringBuilder.toString();
        }
        return paramString;
    }

    public static void main(String[] args) throws java.io.IOException {
         // String pass = passwordDecode("___0022007c0039003b005100e3");
        if (args.length < 2){
            System.out.println("Usage : PassDecode.jar <Method> <Password>");
            System.out.println("--Method [seeyon,fineReport]");
            return;
        }
        if ("seeyon".equals(args[0])) {
            System.out.println(com.seeyon.ctp.util.TextEncoder.decode(args[1]));
        }else if ("fineReport".equals(args[0])){
            String pass = passwordDecode(args[0]);
            System.out.println(pass);
        }

    }

}
