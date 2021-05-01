import java.util.ArrayList;
import java.util.List;

/**
 * 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度
 * 和直系下属的id
 * 现在输入一个公司的所有员工信息，单个员工id，返回这个员工和他所有下属
 * 的重要度之和
 *
 * @author:syx
 * @date: 2021/5/1 20:41
 * @version:v1.0
 */
public class Case690 {
    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();
        //[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
        List<Integer> sub = new ArrayList<>();
        sub.add(2);
        sub.add(3);
        list.add(new Employee(1,5,sub));
        List<Integer> sub2 = new ArrayList<>();
        list.add(new Employee(2,3,sub2));
        List<Integer> sub3 = new ArrayList<>();
        list.add(new Employee(3,3,sub3));
        System.out.println(getImportance(list,1));
    }
    public static int getImportance(List<Employee> employees, int id) {
        if (employees.get(id-1).subordinates.isEmpty()) {
            return employees.get(id-1).importance;
        }
        int countOfimp = employees.get(id-1).importance;
        for (int sid : employees.get(id-1).subordinates) {
            countOfimp += getImportance(employees, sid);
        }
        return countOfimp;
    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
