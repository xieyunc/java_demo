/**
 * 文件名：Student.java
 * 功能描述：类的封装演示，get()、set()使用方法
 *
 */
class Student{
    private String name;	//姓名
    private char sex;		//性别
    private int age;		//年龄
    
    public Student() {
    	
    }
    
    public Student(String name,char sex,int age) {
    	setName(name);
    	setSex(sex);
    	setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
    	if (sex == '男' || sex == '女')
    		this.sex = sex;
    	else {
    		System.out.println("性别必须为【男】或【女】！");
    		this.sex = '男';
    	}
    }
    
    public char getSex() {
    	return sex;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
    	if (age>=18 && age <= 60) {
    		this.age = age;
    	}
    	else {
    		this.age = 18;
    		System.out.println("年龄不合法！");
    	}

    }
    
    public void show(){
        System.out.printf("姓名：%s, 性别：%s, 年龄：%d\n",name,sex,age);
    }

}
