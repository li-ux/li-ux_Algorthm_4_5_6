package com.example.li_ux_algorthm_4_5_6;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.li_ux_algorthm_4_5_6.bean.circle;
import com.example.li_ux_algorthm_4_5_6.bean.Rectangle;
import com.example.li_ux_algorthm_4_5_6.bean.Shape;
import com.example.li_ux_algorthm_4_5_6.bean.Student;
import com.example.li_ux_algorthm_4_5_6.bean.Triangle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private TextView exam4_question1_TV;
    private TextView exam4_question2_TV;
    private TextView exam4_question3_TV;
    private TextView exam5_question1_TV;
    private TextView exam5_question2_TV;
    private TextView exam5_question3_TV;
    private TextView exam6_question1_TV;
    private TextView exam6_question2_TV;
    private TextView exam6_question3_TV;

    private List<Student> stu_list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        for (int i = 65; i < 76; i++) {
            stu_list.add(new Student(i - 64, String.valueOf((char) i), i - 50, i + 2));
        }
        exam4_question1(2);
        exam4_question2();
        exam4_question3();
        exam5_question1(100, 1000);
        exam5_question2();
        exam5_question3();
        exam6_question1();
        exam6_question2();
        exam6_question3_TV.setText("你的月薪是4000元，应打税" + exam6_question3(4000) + "元");
    }

    public void exam4_question1(int n) {
        int resutl = 1;
        for (int i = 0; i < n; i++) {
            resutl += 2 << i;
        }
        exam4_question1_TV.setText(resutl + "");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void exam4_question2() {
        HashMap<String, Integer> score_map = new HashMap<>();
        int score = 0;
        for (int i = 0; i < stu_list.size(); i++) {
            score = (stu_list.get(i)).getScore();
            if (score < 60) {
                score_map.put("不及格", score_map.getOrDefault("不及格", 0) + 1);
            }
            if (score > 60 && score < 70) {
                score_map.put("及格", score_map.getOrDefault("不及格", 0) + 1);
            }
            if (score > 70 && score < 80) {
                score_map.put("中等", score_map.getOrDefault("不及格", 0) + 1);
            }
            if (score > 80 && score < 90) {
                score_map.put("良好", score_map.getOrDefault("不及格", 0) + 1);
            }
            if (score > 90) {
                score_map.put("优秀", score_map.getOrDefault("不及格", 0) + 1);
            }
        }
        exam4_question2_TV.setText(score_map.toString());
    }

    public void exam4_question3() {
        TreeSet<Student> stu_set = new TreeSet<>();
        stu_set.addAll(stu_list);
        String str = "ID:\t";
        for (Student stu : stu_set) {
            str += stu.getId() + " ";
            stu.setAge(stu.getAge() + 1);
        }
        str += "\r\n大于20岁的人数";
        int old_stu_num = 0;
        for (Student stu : stu_set) {
            if (stu.getAge() > 20)
                old_stu_num += 1;
        }
        str += old_stu_num;
        exam4_question3_TV.setText(str + "");
    }

    public void exam5_question1(int start, int end) {
        //质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。    168
        List<Integer> p_list = new ArrayList<>();
        List<Integer> f_list = new ArrayList<>();
        for (int i = 3; i <= end; i += 2) {
            f_list.add(i);
            for (int j : f_list) {
                if (i % j == 0){
                    p_list.add(i);
                    break;
                }
                else
                    continue;
            }
        }
        Log.e("asd", p_list.size() + "");
        Log.e("asd", f_list.toString());
        Log.e("asd", p_list.toString());
    }

    public void exam5_question2 () {
        int result1 = 0;
        int result2 = 0;
        for (int i : new int[]{2, 4, 5}) {
            result1 += exam5_question2_answer1(i, 1);
            result2 += exam5_question2_answer2(i);
        }
        exam5_question2_TV.setText("递归:" + result1 + "\t非递归:" + result2);
    }

    public int exam5_question2_answer1 ( int target, int cur){
        if (target == 1)
            return cur;
        else
            return exam5_question2_answer1(target - 1, cur * target);
    }

    public int exam5_question2_answer2 ( int target){
        int result = 1;
        for (int i = 1; i <= target; i++)
            result *= i;
        return result;
    }

    public void exam5_question3 () {
        Shape triangle = new Triangle(10, 10);
        Shape rectangle = new Rectangle(10, 10);
        Shape circle = new circle(10);
        exam5_question3_TV.setText("三角形:" + triangle.calArea() + "\t矩形:" + rectangle.calArea() + "\t圆形:" + circle.calArea());
    }

    public void exam6_question1 () {
        double[] num_arr = {9.8, 12, 45, 67, 23, 1.98, 2.55, 45};
        double max = 0;
        double min = 0;
        double avg = 0;
        for (int i = 0; i < num_arr.length; i++) {
            if (i == 0)
                min = num_arr[i];
            max = num_arr[i] > max ? num_arr[i] : max;
            min = num_arr[i] > min ? min : num_arr[i];
            avg += num_arr[i];
        }

        avg = avg / num_arr.length;
        exam6_question1_TV.setText("最大值:" + max + "\t最小值" + min + "\t平均值:" + avg);
    }

    public void exam6_question2 () {
        File f = new File(MainActivity.this.getFilesDir(), "WriteArr.txt");
        FileOutputStream fileOutputStream = null;
        char[] chars = "FEDCBA".toCharArray();
        try {
            fileOutputStream = new FileOutputStream(f);
            fileOutputStream.write("FEDCBA".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String str = "";
        for (char c : chars) {
            str += c + "\t";
        }
        exam6_question2_TV.setText(str);
    }

    public double exam6_question3 ( int salary){
        salary -= 3000;
        if (salary < 1500) {
            return salary * 0.05;
        } else if (salary < 4500) {
            return 1500 * 0.05 + (salary - 1500) * 0.1;
        } else if (salary < 9000) {
            return 1500 * 0.05 + 3000 * 0.1 + (salary - 4500) * 0.2;
        } else if (salary < 35000) {
            return 1500 * 0.05 + 3000 * 0.1 + 4500 * 0.2 + (salary - 9000) * 0.25;
        } else if (salary < 55000) {
            return 1500 * 0.05 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + (salary - 35000) * 0.3;
        } else if (salary < 80000) {
            return 1500 * 0.05 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + 20000 * 0.3 + (salary - 55000) * 0.35;
        } else if (salary > 80000) {
            return 1500 * 0.05 + 3000 * 0.1 + 4500 * 0.2 + 26000 * 0.25 + 20000 * 0.3 + 25000 * 0.35 + (salary - 80000) * 0.45;
        }
        return 0;
    }

    private void initView () {
        exam4_question1_TV = (TextView) findViewById(R.id.exam4_question1_TV);
        exam4_question2_TV = (TextView) findViewById(R.id.exam4_question2_TV);
        exam4_question3_TV = (TextView) findViewById(R.id.exam4_question3_TV);
        exam5_question1_TV = (TextView) findViewById(R.id.exam5_question1_TV);
        exam5_question2_TV = (TextView) findViewById(R.id.exam5_question2_TV);
        exam5_question3_TV = (TextView) findViewById(R.id.exam5_question3_TV);
        exam6_question1_TV = (TextView) findViewById(R.id.exam6_question1_TV);
        exam6_question2_TV = (TextView) findViewById(R.id.exam6_question2_TV);
        exam6_question3_TV = (TextView) findViewById(R.id.exam6_question3_TV);
    }
}

