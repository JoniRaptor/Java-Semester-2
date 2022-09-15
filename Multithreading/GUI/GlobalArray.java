import java.util.ArrayList;

class GlobalArray {
    public static ArrayList<String> Output = new ArrayList<String>();
    
    public static String[] OutputArray = {"test"};

    public static String[] getOutpuArray(ArrayList<String> Output){
        String[] out = new String[Output.size()];
        for (int i = 0; i < Output.size(); i++){
            out[i] = Output.get(i);
        }
        return out;
    }
}