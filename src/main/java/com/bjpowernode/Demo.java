package com.bjpowernode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    public static void main(String[] args) throws IOException {

        //ReadDate.readData();
        String anPath = "C:\\ProgramData\\Anaconda3\\python.exe";
        String pyPath = "C:\\Users\\16498\\Desktop\\python\\ECG_mulclassfication\\predict.py";
        String xlPath = "C:\\Users\\16498\\Desktop\\java\\java_projects\\springmvc-course\\ecg_classfication\\src\\main\\resources\\test.xlsx";
        String mdPath = "C:\\Users\\16498\\Desktop\\java\\java_projects\\springmvc-course\\ecg_classfication\\src\\main\\resources\\my_model.pth";
        String[] arguments = new String[] {anPath,pyPath,mdPath,xlPath};   //这里构建要在cmd中输入的参数，第二个参数表示.py文件的路径，第二个之后的参数都表示要传给.py文件的参数，可以根据.py文件的需求写
        try {
            Process process = Runtime.getRuntime().exec(arguments);//这个方法相当于在cmd中输入 python pyPath xlPath
            //System.out.println(process);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //System.out.println(in);
            String line = null;
            int cnt = 0;
            while ((line = in.readLine()) != null) {
                //System.out.println(line);  //在java编译器中打印.py文件的执行结果
                cnt += 1;
                switch (line) {
                    case "0":
                        System.out.println("第"+cnt+"位测试者是APC患者");
                        break;
                    case "1":
                        System.out.println("第"+cnt+"位测试者是LBB患者");
                        break;
                    case "2":
                        System.out.println("第"+cnt+"位测试者是健康的");
                        break;
                    case "3":
                        System.out.println("第"+cnt+"位测试者是PAB患者");
                        break;
                    case "4":
                        System.out.println("第"+cnt+"位测试者是PVC患者");
                        break;
                    case "5":
                        System.out.println("第"+cnt+"位测试者是RBB患者");
                        break;
                    case "6":
                        System.out.println("第"+cnt+"位测试者是VEB患者");
                        break;
                    default:
                        break;
                }
            }
            //System.out.println(cnt);
            in.close();
            int re = process.waitFor();//因为是process这个进程调用.py文件， 所以要将当前进程阻塞等待.py文件执行完毕， 若果.py文件成功运行完毕，此方法将返回0，代表执行成功
            if (re != 0){
                System.out.println(re);//执行成功的话这里会打印一个0，否则会打印1，2或者其他数字
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
