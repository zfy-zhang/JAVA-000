# 学习笔记

## 作业：2、3（内存关系图在resource文件夹下）

## 补：补充学习笔记及作业

### 一、字节码

##### java代码
```java
/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/23
 * @Modify
 * @since
 */
public class ArithmeticTest {

    public static void main(String[] args) {

        int a = 3;
        int b = 8;

        int c = b - a;
        int d = a + b;
        int e = a * b;
        int f = b / a;

        Map<Integer, String> map = new HashMap<>();
        map.put(c , "我是减法运算.......");
        map.put(d , "我是加法运算.......");
        map.put(e , "我是乘法运算.......");
        map.put(f , "我是除法运算.......");

        List<Integer> list = Arrays.asList(c, d, e, f);

        for (Integer integer : list) {
            if (1 == integer%2) {
                System.out.println(map.get(integer));
            }
        }

    }
}
```
##### 字节码
```java
Classfile /Users/alisha/IdeaProjects/JAVA-000/Week_01/classLoader/src/main/java/org/geekbang/java/ArithmeticTest.class
  Last modified 2020年10月23日; size 1416 bytes
  MD5 checksum c22330c420ff9507383950c255c117d7
  Compiled from "ArithmeticTest.java"
public class org.geekbang.java.ArithmeticTest
  minor version: 0
  major version: 55
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #20                         // org/geekbang/java/ArithmeticTest
  super_class: #21                        // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #21.#35        // java/lang/Object."<init>":()V
   #2 = Class              #36            // java/util/HashMap
   #3 = Methodref          #2.#35         // java/util/HashMap."<init>":()V
   #4 = Methodref          #10.#37        // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   #5 = String             #38            // 我是减法运算.......
   #6 = InterfaceMethodref #30.#39        // java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   #7 = String             #40            // 我是加法运算.......
   #8 = String             #41            // 我是乘法运算.......
   #9 = String             #42            // 我是除法运算.......
  #10 = Class              #43            // java/lang/Integer
  #11 = Methodref          #44.#45        // java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
  #12 = InterfaceMethodref #31.#46        // java/util/List.iterator:()Ljava/util/Iterator;
  #13 = InterfaceMethodref #32.#47        // java/util/Iterator.hasNext:()Z
  #14 = InterfaceMethodref #32.#48        // java/util/Iterator.next:()Ljava/lang/Object;
  #15 = Methodref          #10.#49        // java/lang/Integer.intValue:()I
  #16 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
  #17 = InterfaceMethodref #30.#52        // java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
  #18 = Class              #53            // java/lang/String
  #19 = Methodref          #54.#55        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #20 = Class              #56            // org/geekbang/java/ArithmeticTest
  #21 = Class              #57            // java/lang/Object
  #22 = Utf8               <init>
  #23 = Utf8               ()V
  #24 = Utf8               Code
  #25 = Utf8               LineNumberTable
  #26 = Utf8               main
  #27 = Utf8               ([Ljava/lang/String;)V
  #28 = Utf8               StackMapTable
  #29 = Class              #58            // "[Ljava/lang/String;"
  #30 = Class              #59            // java/util/Map
  #31 = Class              #60            // java/util/List
  #32 = Class              #61            // java/util/Iterator
  #33 = Utf8               SourceFile
  #34 = Utf8               ArithmeticTest.java
  #35 = NameAndType        #22:#23        // "<init>":()V
  #36 = Utf8               java/util/HashMap
  #37 = NameAndType        #62:#63        // valueOf:(I)Ljava/lang/Integer;
  #38 = Utf8               我是减法运算.......
  #39 = NameAndType        #64:#65        // put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
  #40 = Utf8               我是加法运算.......
  #41 = Utf8               我是乘法运算.......
  #42 = Utf8               我是除法运算.......
  #43 = Utf8               java/lang/Integer
  #44 = Class              #66            // java/util/Arrays
  #45 = NameAndType        #67:#68        // asList:([Ljava/lang/Object;)Ljava/util/List;
  #46 = NameAndType        #69:#70        // iterator:()Ljava/util/Iterator;
  #47 = NameAndType        #71:#72        // hasNext:()Z
  #48 = NameAndType        #73:#74        // next:()Ljava/lang/Object;
  #49 = NameAndType        #75:#76        // intValue:()I
  #50 = Class              #77            // java/lang/System
  #51 = NameAndType        #78:#79        // out:Ljava/io/PrintStream;
  #52 = NameAndType        #80:#81        // get:(Ljava/lang/Object;)Ljava/lang/Object;
  #53 = Utf8               java/lang/String
  #54 = Class              #82            // java/io/PrintStream
  #55 = NameAndType        #83:#84        // println:(Ljava/lang/String;)V
  #56 = Utf8               org/geekbang/java/ArithmeticTest
  #57 = Utf8               java/lang/Object
  #58 = Utf8               [Ljava/lang/String;
  #59 = Utf8               java/util/Map
  #60 = Utf8               java/util/List
  #61 = Utf8               java/util/Iterator
  #62 = Utf8               valueOf
  #63 = Utf8               (I)Ljava/lang/Integer;
  #64 = Utf8               put
  #65 = Utf8               (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
  #66 = Utf8               java/util/Arrays
  #67 = Utf8               asList
  #68 = Utf8               ([Ljava/lang/Object;)Ljava/util/List;
  #69 = Utf8               iterator
  #70 = Utf8               ()Ljava/util/Iterator;
  #71 = Utf8               hasNext
  #72 = Utf8               ()Z
  #73 = Utf8               next
  #74 = Utf8               ()Ljava/lang/Object;
  #75 = Utf8               intValue
  #76 = Utf8               ()I
  #77 = Utf8               java/lang/System
  #78 = Utf8               out
  #79 = Utf8               Ljava/io/PrintStream;
  #80 = Utf8               get
  #81 = Utf8               (Ljava/lang/Object;)Ljava/lang/Object;
  #82 = Utf8               java/io/PrintStream
  #83 = Utf8               println
  #84 = Utf8               (Ljava/lang/String;)V
{
  public org.geekbang.java.ArithmeticTest();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 12: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=11, args_size=1
         0: iconst_3
         1: istore_1
         2: bipush        8
         4: istore_2
         5: iload_2
         6: iload_1
         7: isub
         8: istore_3
         9: iload_1
        10: iload_2
        11: iadd
        12: istore        4
        14: iload_1
        15: iload_2
        16: imul
        17: istore        5
        19: iload_2
        20: iload_1
        21: idiv
        22: istore        6
        24: new           #2                  // class java/util/HashMap
        27: dup
        28: invokespecial #3                  // Method java/util/HashMap."<init>":()V
        31: astore        7
        33: aload         7
        35: iload_3
        36: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        39: ldc           #5                  // String 我是减法运算.......
        41: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        46: pop
        47: aload         7
        49: iload         4
        51: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        54: ldc           #7                  // String 我是加法运算.......
        56: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        61: pop
        62: aload         7
        64: iload         5
        66: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        69: ldc           #8                  // String 我是乘法运算.......
        71: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        76: pop
        77: aload         7
        79: iload         6
        81: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        84: ldc           #9                  // String 我是除法运算.......
        86: invokeinterface #6,  3            // InterfaceMethod java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        91: pop
        92: iconst_4
        93: anewarray     #10                 // class java/lang/Integer
        96: dup
        97: iconst_0
        98: iload_3
        99: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       102: aastore
       103: dup
       104: iconst_1
       105: iload         4
       107: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       110: aastore
       111: dup
       112: iconst_2
       113: iload         5
       115: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       118: aastore
       119: dup
       120: iconst_3
       121: iload         6
       123: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       126: aastore
       127: invokestatic  #11                 // Method java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
       130: astore        8
       132: aload         8
       134: invokeinterface #12,  1           // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
       139: astore        9
       141: aload         9
       143: invokeinterface #13,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
       148: ifeq          195
       151: aload         9
       153: invokeinterface #14,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
       158: checkcast     #10                 // class java/lang/Integer
       161: astore        10
       163: iconst_1
       164: aload         10
       166: invokevirtual #15                 // Method java/lang/Integer.intValue:()I
       169: iconst_2
       170: irem
       171: if_icmpne     192
       174: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
       177: aload         7
       179: aload         10
       181: invokeinterface #17,  2           // InterfaceMethod java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
       186: checkcast     #18                 // class java/lang/String
       189: invokevirtual #19                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       192: goto          141
       195: return
      LineNumberTable:
        line 16: 0
        line 17: 2
        line 19: 5
        line 20: 9
        line 21: 14
        line 22: 19
        line 24: 24
        line 25: 33
        line 26: 47
        line 27: 62
        line 28: 77
        line 30: 92
        line 32: 132
        line 33: 163
        line 34: 174
        line 36: 192
        line 38: 195
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 141
          locals = [ class "[Ljava/lang/String;", int, int, int, int, int, int, class java/util/Map, class java/util/List, class java/util/Iterator ]
          stack = []
        frame_type = 50 /* same */
        frame_type = 250 /* chop */
          offset_delta = 2
}
SourceFile: "ArithmeticTest.java"

```

