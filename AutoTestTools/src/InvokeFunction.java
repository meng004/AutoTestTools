import java.io.*;
import java.util.ArrayList;

/**
 * ����fortran��������
 * @author skl
 *
 */
public class InvokeFunction {
    private File fileName = new File("invoke.f");
    private String sixBlank = "      ";
    
    private ArrayList<Parameters> paramArray;
    private ArrayList<GlobeVariable> globeArray;

    private String funcName;
        
    /**
     * ��������
     * @param objectArray  UI_2��������������
     */
    public InvokeFunction(String funcName, ArrayList<Parameters> paramArray, ArrayList<GlobeVariable> globeArray){
    	this.funcName = funcName; 	
    	this.paramArray = paramArray; 	
    	this.globeArray = globeArray; 
    }
    
    /**
     * ��������fortran��������
     */
    public void writeFile() throws Exception{
    	//��������������
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        
        
        raf.writeBytes( //������
        		sixBlank + "program x \r\n" +
        		"!------ \r\n");
        
        //��������
    	for(int i=0; i<globeArray.size(); i++){ //������������
    		raf.writeBytes(sixBlank+ "common /" + globeArray.get(i).getType() +"/"+ globeArray.get(i).getName() +"\r\n");
    	}
    	for(int i=0; i<paramArray.size(); i++){	//��������
    		raf.writeBytes(sixBlank+ paramArray.get(i).getParamType() +" "+ paramArray.get(i).getParamName() +"\r\n");
        }
 
    	//��������
    	raf.writeBytes("!------ \r\n");
    	for(int i=0; i<globeArray.size(); i++){ //������������
    		raf.writeBytes(sixBlank+ globeArray.get(i).getName() +"="+ globeArray.get(i).getValue() +"\r\n");
    	}
    	for(int i=0; i<paramArray.size(); i++){ //��������
    		raf.writeBytes(sixBlank+ paramArray.get(i).getParamName() +"="+ paramArray.get(i).getParamValue() +"\r\n");
    	}
		
		//��������
    	raf.writeBytes( "!------ \r\n" +
    			sixBlank+ "print *,'callfunc=',"+funcName+"("); 
    	for(int i=0; i<paramArray.size(); i++){  //����������
    		raf.writeBytes( paramArray.get(i).getParamName() );
    		if(i != paramArray.size()-1){ raf.writeBytes(", ");}
    	}
    	raf.writeBytes( ") \r\n"  + sixBlank + "open(unit=2, file='OutputFile.txt')  \r\n" + sixBlank + "write(2,*) 'save data succeed!!'   \r\n");
    	raf.writeBytes(sixBlank + "end");
    
        System.out.println("��������");
        raf.close();
    }
    

//    /**
//     * main
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception {
//    	CreateFortranInvoke cfi = new CreateFortranInvoke();
//    	//��������
//    	cfi.writeFile();  	
//    }
}

