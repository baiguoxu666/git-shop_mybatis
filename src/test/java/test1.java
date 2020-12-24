import com.bgx.entity.Category;
import com.bgx.entity.User;
import com.bgx.service.CategoryService;
import com.bgx.service.UserService;
import com.bgx.util.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class test1 extends BaseTest{

    @Autowired
    private UserService us;
    @Autowired
    private CategoryService cs;

    @Test
    public void testa(){
        System.out.println(new Date());
        System.out.println(MD5Util.getMD5("123456"));
    }

    @Test
    public void testb(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        UserService us = (UserService) context.getBean("UserService");

       User user = new User("2", "peter", "6afdaeb99e51bfaeea24e1f59c944874", "u7RN", new Date());
       us.select(user);


    }


    @Test
    public void testc(){
        User user = new User(null, "机器猫", "123456", null, null);
        us.insert(user);
    }


    @Test
    public void testd(){
      int[] a={21,12,23,34,43,23,12,3,5};
      for(int i=0;i<a.length-1;i++){
          for(int j=0;j<a.length-1-i;j++){
              if(a[j]>a[j+1]){
                  int tmp=a[j+1];
                  a[j+1]=a[j];
                  a[j]=tmp;
              }
          }
      }


       for(int i=0;i<a.length;i++){
           System.out.println(a[i]);
       }

    }


    @Test
    public void teste(){
        Hashtable<Object, Object> table = new Hashtable<>();
        HashMap<Object, Object> map = new HashMap<>();
        //table.put(null,null);
        map.put(null,null);
        map.put(null,1);
        System.out.println(table);
        System.out.println(map);
    }


    @Test
    public void testf(){
//        Category category = cs.queryById(1);
//        System.out.println(category);
        Category category = new Category(null, "胸罩", null, 2);
        cs.save(category,6);
    }
}
