## 学习笔记

#### 作业一：使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

**注：本次执行环境为：MacOS、 jdk1.8_131、4核、16G**

##### 1、串行 GC（仅以 512m 作示例）

执行脚本：java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis

```java
ElishadeMacBook-Pro:java alisha$ java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis
正在执行...
2020-10-27T22:50:49.787-0800: [GC (Allocation Failure) 2020-10-27T22:50:49.787-0800: [DefNew: 139776K->17472K(157248K), 0.0368717 secs] 139776K->47427K(506816K), 0.0369225 secs] [Times: user=0.02 sys=0.02, real=0.04 secs] 
2020-10-27T22:50:49.872-0800: [GC (Allocation Failure) 2020-10-27T22:50:49.872-0800: [DefNew: 156933K->17471K(157248K), 0.0472539 secs] 186889K->91086K(506816K), 0.0472995 secs] [Times: user=0.04 sys=0.02, real=0.04 secs] 
2020-10-27T22:50:49.945-0800: [GC (Allocation Failure) 2020-10-27T22:50:49.945-0800: [DefNew: 157247K->17471K(157248K), 0.0492070 secs] 230862K->133283K(506816K), 0.0492412 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2020-10-27T22:50:50.020-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.020-0800: [DefNew: 157247K->17471K(157248K), 0.0572302 secs] 273059K->177357K(506816K), 0.0573015 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2020-10-27T22:50:50.107-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.107-0800: [DefNew: 157247K->17471K(157248K), 0.0503547 secs] 317133K->220473K(506816K), 0.0504085 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2020-10-27T22:50:50.187-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.187-0800: [DefNew: 157247K->17467K(157248K), 0.0540103 secs] 360249K->262942K(506816K), 0.0540605 secs] [Times: user=0.03 sys=0.02, real=0.06 secs] 
2020-10-27T22:50:50.262-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.262-0800: [DefNew: 157243K->17472K(157248K), 0.0472809 secs] 402718K->310189K(506816K), 0.0473186 secs] [Times: user=0.03 sys=0.02, real=0.04 secs] 
2020-10-27T22:50:50.344-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.344-0800: [DefNew: 157248K->17472K(157248K), 0.0365129 secs] 449965K->353999K(506816K), 0.0365778 secs] [Times: user=0.02 sys=0.01, real=0.04 secs] 
2020-10-27T22:50:50.427-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.427-0800: [DefNew: 157248K->157248K(157248K), 0.0000668 secs]2020-10-27T22:50:50.427-0800: [Tenured: 336527K->287004K(349568K), 0.0778028 secs] 493775K->287004K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0779811 secs] [Times: user=0.07 sys=0.00, real=0.08 secs] 
2020-10-27T22:50:50.528-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.528-0800: [DefNew: 139700K->17466K(157248K), 0.0109996 secs] 426704K->337475K(506816K), 0.0110337 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
2020-10-27T22:50:50.574-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.574-0800: [DefNew: 157242K->157242K(157248K), 0.0000170 secs]2020-10-27T22:50:50.574-0800: [Tenured: 320009K->304761K(349568K), 0.0760310 secs] 477251K->304761K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0760984 secs] [Times: user=0.08 sys=0.00, real=0.08 secs] 
2020-10-27T22:50:50.672-0800: [GC (Allocation Failure) 2020-10-27T22:50:50.672-0800: [DefNew: 139776K->17470K(157248K), 0.0115710 secs] 444537K->350912K(506816K), 0.0116253 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
执行结束!共生成对象次数:6308
Heap
 def new generation   total 157248K, used 47747K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  21% used [0x00000007a0000000, 0x00000007a1d911f0, 0x00000007a8880000)
  from space 17472K,  99% used [0x00000007a8880000, 0x00000007a998fa20, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 tenured generation   total 349568K, used 333441K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
   the space 349568K,  95% used [0x00000007aaaa0000, 0x00000007bf040710, 0x00000007bf040800, 0x00000007c0000000)
 Metaspace       used 2710K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```

##### 2、并行 GC（仅以 512m 作示例）

执行脚本：java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis

```java
ElishadeMacBook-Pro:java alisha$ java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis
正在执行...
2020-10-27T22:52:29.439-0800: [GC (Allocation Failure) [PSYoungGen: 131308K->21485K(153088K)] 131308K->43914K(502784K), 0.0193420 secs] [Times: user=0.02 sys=0.10, real=0.02 secs] 
2020-10-27T22:52:29.487-0800: [GC (Allocation Failure) [PSYoungGen: 153069K->21501K(153088K)] 175498K->87814K(502784K), 0.0431539 secs] [Times: user=0.05 sys=0.18, real=0.05 secs] 
2020-10-27T22:52:29.569-0800: [GC (Allocation Failure) [PSYoungGen: 153085K->21490K(153088K)] 219398K->129750K(502784K), 0.0308200 secs] [Times: user=0.05 sys=0.13, real=0.03 secs] 
2020-10-27T22:52:29.629-0800: [GC (Allocation Failure) [PSYoungGen: 153074K->21492K(153088K)] 261334K->170896K(502784K), 0.0346038 secs] [Times: user=0.06 sys=0.12, real=0.04 secs] 
2020-10-27T22:52:29.692-0800: [GC (Allocation Failure) [PSYoungGen: 153076K->21488K(153088K)] 302480K->215460K(502784K), 0.0409957 secs] [Times: user=0.07 sys=0.12, real=0.04 secs] 
2020-10-27T22:52:29.768-0800: [GC (Allocation Failure) [PSYoungGen: 153072K->21495K(80384K)] 347044K->257839K(430080K), 0.0323156 secs] [Times: user=0.05 sys=0.10, real=0.04 secs] 
2020-10-27T22:52:29.816-0800: [GC (Allocation Failure) [PSYoungGen: 80025K->38196K(116736K)] 316369K->277291K(466432K), 0.0148086 secs] [Times: user=0.05 sys=0.01, real=0.02 secs] 
2020-10-27T22:52:29.846-0800: [GC (Allocation Failure) [PSYoungGen: 97044K->51345K(116736K)] 336139K->295587K(466432K), 0.0101073 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T22:52:29.880-0800: [GC (Allocation Failure) [PSYoungGen: 110023K->55483K(116736K)] 354264K->309091K(466432K), 0.0196933 secs] [Times: user=0.06 sys=0.04, real=0.02 secs] 
2020-10-27T22:52:29.921-0800: [GC (Allocation Failure) [PSYoungGen: 113951K->32053K(116736K)] 367559K->321722K(466432K), 0.0451271 secs] [Times: user=0.05 sys=0.09, real=0.04 secs] 
2020-10-27T22:52:29.967-0800: [Full GC (Ergonomics) [PSYoungGen: 32053K->0K(116736K)] [ParOldGen: 289668K->237036K(349696K)] 321722K->237036K(466432K), [Metaspace: 2703K->2703K(1056768K)], 0.0493864 secs] [Times: user=0.25 sys=0.02, real=0.05 secs] 
2020-10-27T22:52:30.030-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->17828K(116736K)] 295916K->254864K(466432K), 0.0056801 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
2020-10-27T22:52:30.055-0800: [GC (Allocation Failure) [PSYoungGen: 76412K->18711K(116736K)] 313448K->272607K(466432K), 0.0046484 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2020-10-27T22:52:30.085-0800: [GC (Allocation Failure) [PSYoungGen: 77591K->19950K(116736K)] 331487K->291435K(466432K), 0.0053256 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2020-10-27T22:52:30.107-0800: [GC (Allocation Failure) [PSYoungGen: 78735K->24627K(116736K)] 350220K->313855K(466432K), 0.0144836 secs] [Times: user=0.06 sys=0.00, real=0.02 secs] 
2020-10-27T22:52:30.135-0800: [GC (Allocation Failure) [PSYoungGen: 83284K->16796K(116736K)] 372512K->328082K(466432K), 0.0276126 secs] [Times: user=0.04 sys=0.08, real=0.03 secs] 
2020-10-27T22:52:30.163-0800: [Full GC (Ergonomics) [PSYoungGen: 16796K->0K(116736K)] [ParOldGen: 311285K->261930K(349696K)] 328082K->261930K(466432K), [Metaspace: 2703K->2703K(1056768K)], 0.0464706 secs] [Times: user=0.20 sys=0.01, real=0.04 secs] 
2020-10-27T22:52:30.231-0800: [GC (Allocation Failure) [PSYoungGen: 58845K->21096K(116736K)] 320775K->283026K(466432K), 0.0031894 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
2020-10-27T22:52:30.246-0800: [GC (Allocation Failure) [PSYoungGen: 79976K->21555K(116736K)] 341906K->303572K(466432K), 0.0106525 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T22:52:30.274-0800: [GC (Allocation Failure) [PSYoungGen: 80435K->23823K(116736K)] 362452K->325347K(466432K), 0.0062516 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2020-10-27T22:52:30.304-0800: [GC (Allocation Failure) [PSYoungGen: 82703K->20700K(116736K)] 384227K->343597K(466432K), 0.0114352 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 
2020-10-27T22:52:30.315-0800: [Full GC (Ergonomics) [PSYoungGen: 20700K->0K(116736K)] [ParOldGen: 322897K->286024K(349696K)] 343597K->286024K(466432K), [Metaspace: 2703K->2703K(1056768K)], 0.0530591 secs] [Times: user=0.25 sys=0.00, real=0.05 secs] 
执行结束!共生成对象次数:5818
Heap
 PSYoungGen      total 116736K, used 2631K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b5811fb0,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
  to   space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
 ParOldGen       total 349696K, used 286024K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 81% used [0x00000007a0000000,0x00000007b1752330,0x00000007b5580000)
 Metaspace       used 2710K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```

##### 3、CMS GC（仅以 512m 作示例）

执行脚本：java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis

```java
ElishadeMacBook-Pro:java alisha$ java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis
正在执行...
2020-10-27T16:39:42.986-0800: [GC (Allocation Failure) 2020-10-27T16:39:42.986-0800: [ParNew: 139776K->17470K(157248K), 0.0201503 secs] 139776K->45146K(506816K), 0.0202084 secs] [Times: user=0.03 sys=0.08, real=0.02 secs] 
2020-10-27T16:39:43.049-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.049-0800: [ParNew: 157246K->17472K(157248K), 0.0346045 secs] 184922K->91601K(506816K), 0.0346466 secs] [Times: user=0.08 sys=0.10, real=0.04 secs] 
2020-10-27T16:39:43.111-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.111-0800: [ParNew: 157180K->17472K(157248K), 0.0467352 secs] 231310K->138316K(506816K), 0.0468179 secs] [Times: user=0.24 sys=0.03, real=0.04 secs] 
2020-10-27T16:39:43.194-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.194-0800: [ParNew: 157248K->17469K(157248K), 0.1390549 secs] 278092K->181338K(506816K), 0.1391124 secs] [Times: user=0.67 sys=0.06, real=0.14 secs] 
2020-10-27T16:39:43.364-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.364-0800: [ParNew: 157245K->17470K(157248K), 0.0558855 secs] 321114K->225099K(506816K), 0.0560259 secs] [Times: user=0.21 sys=0.03, real=0.06 secs] 
2020-10-27T16:39:43.421-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 207628K(349568K)] 225279K(506816K), 0.0004255 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.421-0800: [CMS-concurrent-mark-start]
2020-10-27T16:39:43.424-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.424-0800: [CMS-concurrent-preclean-start]
2020-10-27T16:39:43.425-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.426-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T16:39:43.460-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.460-0800: [ParNew: 157246K->17467K(157248K), 0.0587184 secs] 364875K->276243K(506816K), 0.0587742 secs] [Times: user=0.22 sys=0.03, real=0.05 secs] 
2020-10-27T16:39:43.545-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.545-0800: [ParNew: 157243K->17471K(157248K), 0.0594955 secs] 416019K->322605K(506816K), 0.0595606 secs] [Times: user=0.24 sys=0.04, real=0.06 secs] 
2020-10-27T16:39:43.637-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.637-0800: [ParNew: 157247K->157247K(157248K), 0.0000745 secs]2020-10-27T16:39:43.637-0800: [CMS2020-10-27T16:39:43.637-0800: [CMS-concurrent-abortable-preclean: 0.007/0.212 secs] [Times: user=0.55 sys=0.08, real=0.21 secs] 
 (concurrent mode failure): 305133K->246313K(349568K), 0.0857789 secs] 462381K->246313K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0859133 secs] [Times: user=0.09 sys=0.00, real=0.09 secs] 
2020-10-27T16:39:43.753-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.753-0800: [ParNew: 139776K->17471K(157248K), 0.0093289 secs] 386089K->287440K(506816K), 0.0093898 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T16:39:43.763-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 269969K(349568K)] 287658K(506816K), 0.0001592 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.763-0800: [CMS-concurrent-mark-start]
2020-10-27T16:39:43.766-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.766-0800: [CMS-concurrent-preclean-start]
2020-10-27T16:39:43.767-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T16:39:43.767-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T16:39:43.804-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.804-0800: [ParNew: 157247K->17470K(157248K), 0.0267670 secs] 427216K->332190K(506816K), 0.0269051 secs] [Times: user=0.13 sys=0.01, real=0.03 secs] 
2020-10-27T16:39:43.863-0800: [GC (Allocation Failure) 2020-10-27T16:39:43.863-0800: [ParNew: 156587K->156587K(157248K), 0.0000219 secs]2020-10-27T16:39:43.863-0800: [CMS2020-10-27T16:39:43.863-0800: [CMS-concurrent-abortable-preclean: 0.002/0.097 secs] [Times: user=0.20 sys=0.01, real=0.10 secs] 
 (concurrent mode failure): 314719K->282450K(349568K), 0.0840838 secs] 471307K->282450K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0841911 secs] [Times: user=0.08 sys=0.01, real=0.08 secs] 
执行结束!共生成对象次数:5875
Heap
 par new generation   total 157248K, used 6277K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   4% used [0x00000007a0000000, 0x00000007a06215d8, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 concurrent mark-sweep generation total 349568K, used 282450K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2710K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
ElishadeMacBook-Pro:java alisha$ java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis
正在执行...
2020-10-27T22:53:46.596-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.596-0800: [ParNew: 139776K->17472K(157248K), 0.0209279 secs] 139776K->46539K(506816K), 0.0209785 secs] [Times: user=0.03 sys=0.10, real=0.02 secs] 
2020-10-27T22:53:46.663-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.663-0800: [ParNew: 157089K->17472K(157248K), 0.0319068 secs] 186156K->87959K(506816K), 0.0319722 secs] [Times: user=0.08 sys=0.12, real=0.03 secs] 
2020-10-27T22:53:46.729-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.729-0800: [ParNew: 157248K->17472K(157248K), 0.0423471 secs] 227735K->132750K(506816K), 0.0424046 secs] [Times: user=0.23 sys=0.03, real=0.05 secs] 
2020-10-27T22:53:46.803-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.803-0800: [ParNew: 157248K->17470K(157248K), 0.0500123 secs] 272526K->178828K(506816K), 0.0500631 secs] [Times: user=0.28 sys=0.04, real=0.05 secs] 
2020-10-27T22:53:46.883-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.883-0800: [ParNew: 157246K->17471K(157248K), 0.0490595 secs] 318604K->220518K(506816K), 0.0491826 secs] [Times: user=0.25 sys=0.03, real=0.05 secs] 
2020-10-27T22:53:46.933-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 203046K(349568K)] 220625K(506816K), 0.0003488 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T22:53:46.933-0800: [CMS-concurrent-mark-start]
2020-10-27T22:53:46.935-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.01, real=0.00 secs] 
2020-10-27T22:53:46.935-0800: [CMS-concurrent-preclean-start]
2020-10-27T22:53:46.936-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T22:53:46.936-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T22:53:46.959-0800: [GC (Allocation Failure) 2020-10-27T22:53:46.959-0800: [ParNew: 157247K->17471K(157248K), 0.0539043 secs] 360294K->269665K(506816K), 0.0540156 secs] [Times: user=0.26 sys=0.04, real=0.06 secs] 
2020-10-27T22:53:47.054-0800: [GC (Allocation Failure) 2020-10-27T22:53:47.054-0800: [ParNew: 157247K->17471K(157248K), 0.0467811 secs] 409441K->316363K(506816K), 0.0468978 secs] [Times: user=0.25 sys=0.03, real=0.05 secs] 
2020-10-27T22:53:47.139-0800: [GC (Allocation Failure) 2020-10-27T22:53:47.140-0800: [ParNew: 157247K->157247K(157248K), 0.0000217 secs]2020-10-27T22:53:47.140-0800: [CMS2020-10-27T22:53:47.140-0800: [CMS-concurrent-abortable-preclean: 0.004/0.204 secs] [Times: user=0.61 sys=0.07, real=0.21 secs] 
 (concurrent mode failure): 298891K->239885K(349568K), 0.0892374 secs] 456139K->239885K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0893191 secs] [Times: user=0.09 sys=0.00, real=0.09 secs] 
2020-10-27T22:53:47.269-0800: [GC (Allocation Failure) 2020-10-27T22:53:47.269-0800: [ParNew: 139776K->17471K(157248K), 0.0089738 secs] 379661K->280841K(506816K), 0.0090416 secs] [Times: user=0.06 sys=0.01, real=0.01 secs] 
2020-10-27T22:53:47.278-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 263369K(349568K)] 281004K(506816K), 0.0001220 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T22:53:47.278-0800: [CMS-concurrent-mark-start]
2020-10-27T22:53:47.279-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-27T22:53:47.280-0800: [CMS-concurrent-preclean-start]
2020-10-27T22:53:47.280-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T22:53:47.281-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T22:53:47.310-0800: [GC (Allocation Failure) 2020-10-27T22:53:47.310-0800: [ParNew: 157161K->17471K(157248K), 0.0379594 secs] 420531K->325074K(506816K), 0.0380030 secs] [Times: user=0.19 sys=0.01, real=0.03 secs] 
2020-10-27T22:53:47.392-0800: [GC (Allocation Failure) 2020-10-27T22:53:47.392-0800: [ParNew: 157247K->157247K(157248K), 0.0001111 secs]2020-10-27T22:53:47.392-0800: [CMS2020-10-27T22:53:47.392-0800: [CMS-concurrent-abortable-preclean: 0.003/0.112 secs] [Times: user=0.27 sys=0.01, real=0.11 secs] 
 (concurrent mode failure): 307603K->284494K(349568K), 0.0781185 secs] 464850K->284494K(506816K), [Metaspace: 2703K->2703K(1056768K)], 0.0783938 secs] [Times: user=0.07 sys=0.00, real=0.08 secs] 
执行结束!共生成对象次数:6350
Heap
 par new generation   total 157248K, used 123941K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  88% used [0x00000007a0000000, 0x00000007a7909608, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 concurrent mark-sweep generation total 349568K, used 284494K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2710K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```

##### 4、G1 GC（仅以 512m 作示例）

执行脚本：java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGC -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis

```java
ElishadeMacBook-Pro:java alisha$ java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGC -XX:+PrintGCDateStamps org.geekbang.java.jvm.GCLogAnalysis
正在执行...
2020-10-27T22:57:08.134-0800: [GC pause (G1 Evacuation Pause) (young) 28M->9853K(512M), 0.0067731 secs]
2020-10-27T22:57:08.152-0800: [GC pause (G1 Evacuation Pause) (young) 38M->20M(512M), 0.0035169 secs]
2020-10-27T22:57:08.185-0800: [GC pause (G1 Evacuation Pause) (young) 73M->35M(512M), 0.0063134 secs]
2020-10-27T22:57:08.223-0800: [GC pause (G1 Evacuation Pause) (young) 111M->65M(512M), 0.0123283 secs]
2020-10-27T22:57:08.262-0800: [GC pause (G1 Evacuation Pause) (young) 153M->97M(512M), 0.0162625 secs]
2020-10-27T22:57:08.348-0800: [GC pause (G1 Evacuation Pause) (young) 249M->152M(512M), 0.0214638 secs]
2020-10-27T22:57:08.416-0800: [GC pause (G1 Evacuation Pause) (young) 296M->198M(512M), 0.0203497 secs]
2020-10-27T22:57:08.455-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 265M->220M(512M), 0.0054632 secs]
2020-10-27T22:57:08.461-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.461-0800: [GC concurrent-root-region-scan-end, 0.0001524 secs]
2020-10-27T22:57:08.461-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.465-0800: [GC concurrent-mark-end, 0.0042658 secs]
2020-10-27T22:57:08.466-0800: [GC remark, 0.0020457 secs]
2020-10-27T22:57:08.468-0800: [GC cleanup 228M->228M(512M), 0.0010713 secs]
2020-10-27T22:57:08.552-0800: [GC pause (G1 Evacuation Pause) (young)-- 407M->319M(512M), 0.0473523 secs]
2020-10-27T22:57:08.605-0800: [GC pause (G1 Evacuation Pause) (mixed) 326M->306M(512M), 0.0063683 secs]
2020-10-27T22:57:08.612-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 307M->306M(512M), 0.0010958 secs]
2020-10-27T22:57:08.613-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.613-0800: [GC concurrent-root-region-scan-end, 0.0001007 secs]
2020-10-27T22:57:08.613-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.614-0800: [GC concurrent-mark-end, 0.0014124 secs]
2020-10-27T22:57:08.614-0800: [GC remark, 0.0017077 secs]
2020-10-27T22:57:08.616-0800: [GC cleanup 315M->315M(512M), 0.0006561 secs]
2020-10-27T22:57:08.654-0800: [GC pause (G1 Evacuation Pause) (young) 415M->339M(512M), 0.0045603 secs]
2020-10-27T22:57:08.666-0800: [GC pause (G1 Evacuation Pause) (mixed) 358M->302M(512M), 0.0071882 secs]
2020-10-27T22:57:08.680-0800: [GC pause (G1 Evacuation Pause) (mixed) 329M->287M(512M), 0.0106265 secs]
2020-10-27T22:57:08.691-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 290M->288M(512M), 0.0024763 secs]
2020-10-27T22:57:08.694-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.694-0800: [GC concurrent-root-region-scan-end, 0.0001952 secs]
2020-10-27T22:57:08.694-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.696-0800: [GC concurrent-mark-end, 0.0014274 secs]
2020-10-27T22:57:08.696-0800: [GC remark, 0.0015251 secs]
2020-10-27T22:57:08.697-0800: [GC cleanup 294M->294M(512M), 0.0005983 secs]
2020-10-27T22:57:08.734-0800: [GC pause (G1 Evacuation Pause) (young) 400M->321M(512M), 0.0108142 secs]
2020-10-27T22:57:08.747-0800: [GC pause (G1 Evacuation Pause) (mixed) 336M->303M(512M), 0.0050497 secs]
2020-10-27T22:57:08.754-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 308M->305M(512M), 0.0016911 secs]
2020-10-27T22:57:08.756-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.756-0800: [GC concurrent-root-region-scan-end, 0.0001140 secs]
2020-10-27T22:57:08.756-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.757-0800: [GC concurrent-mark-end, 0.0012193 secs]
2020-10-27T22:57:08.757-0800: [GC remark, 0.0017023 secs]
2020-10-27T22:57:08.759-0800: [GC cleanup 310M->310M(512M), 0.0008053 secs]
2020-10-27T22:57:08.760-0800: [GC concurrent-cleanup-start]
2020-10-27T22:57:08.760-0800: [GC concurrent-cleanup-end, 0.0000178 secs]
2020-10-27T22:57:08.789-0800: [GC pause (G1 Evacuation Pause) (young) 410M->337M(512M), 0.0051340 secs]
2020-10-27T22:57:08.805-0800: [GC pause (G1 Evacuation Pause) (mixed) 355M->318M(512M), 0.0094096 secs]
2020-10-27T22:57:08.815-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 321M->318M(512M), 0.0011020 secs]
2020-10-27T22:57:08.816-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.816-0800: [GC concurrent-root-region-scan-end, 0.0000839 secs]
2020-10-27T22:57:08.816-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.817-0800: [GC concurrent-mark-end, 0.0009249 secs]
2020-10-27T22:57:08.817-0800: [GC remark, 0.0014329 secs]
2020-10-27T22:57:08.819-0800: [GC cleanup 323M->323M(512M), 0.0011576 secs]
2020-10-27T22:57:08.853-0800: [GC pause (G1 Evacuation Pause) (young) 411M->343M(512M), 0.0116514 secs]
2020-10-27T22:57:08.869-0800: [GC pause (G1 Evacuation Pause) (mixed) 364M->331M(512M), 0.0179288 secs]
2020-10-27T22:57:08.890-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 334M->330M(512M), 0.0021653 secs]
2020-10-27T22:57:08.892-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.892-0800: [GC concurrent-root-region-scan-end, 0.0001265 secs]
2020-10-27T22:57:08.892-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.893-0800: [GC concurrent-mark-end, 0.0012007 secs]
2020-10-27T22:57:08.893-0800: [GC remark, 0.0015508 secs]
2020-10-27T22:57:08.895-0800: [GC cleanup 337M->337M(512M), 0.0006192 secs]
2020-10-27T22:57:08.896-0800: [GC concurrent-cleanup-start]
2020-10-27T22:57:08.896-0800: [GC concurrent-cleanup-end, 0.0000102 secs]
2020-10-27T22:57:08.918-0800: [GC pause (G1 Evacuation Pause) (young) 403M->351M(512M), 0.0073516 secs]
2020-10-27T22:57:08.937-0800: [GC pause (G1 Evacuation Pause) (mixed) 374M->337M(512M), 0.0082303 secs]
2020-10-27T22:57:08.945-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 338M->337M(512M), 0.0031766 secs]
2020-10-27T22:57:08.949-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:08.949-0800: [GC concurrent-root-region-scan-end, 0.0000686 secs]
2020-10-27T22:57:08.949-0800: [GC concurrent-mark-start]
2020-10-27T22:57:08.951-0800: [GC concurrent-mark-end, 0.0023914 secs]
2020-10-27T22:57:08.951-0800: [GC remark, 0.0027759 secs]
2020-10-27T22:57:08.954-0800: [GC cleanup 341M->341M(512M), 0.0014429 secs]
2020-10-27T22:57:08.981-0800: [GC pause (G1 Evacuation Pause) (young) 398M->355M(512M), 0.0038162 secs]
2020-10-27T22:57:08.992-0800: [GC pause (G1 Evacuation Pause) (mixed) 382M->346M(512M), 0.0076005 secs]
2020-10-27T22:57:09.002-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 349M->347M(512M), 0.0039979 secs]
2020-10-27T22:57:09.006-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:09.007-0800: [GC concurrent-root-region-scan-end, 0.0005571 secs]
2020-10-27T22:57:09.007-0800: [GC concurrent-mark-start]
2020-10-27T22:57:09.010-0800: [GC concurrent-mark-end, 0.0029229 secs]
2020-10-27T22:57:09.010-0800: [GC remark, 0.0022669 secs]
2020-10-27T22:57:09.012-0800: [GC cleanup 352M->352M(512M), 0.0017164 secs]
2020-10-27T22:57:09.032-0800: [GC pause (G1 Evacuation Pause) (young) 397M->358M(512M), 0.0060246 secs]
2020-10-27T22:57:09.045-0800: [GC pause (G1 Evacuation Pause) (mixed) 384M->352M(512M), 0.0114003 secs]
2020-10-27T22:57:09.057-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 352M->351M(512M), 0.0025278 secs]
2020-10-27T22:57:09.060-0800: [GC concurrent-root-region-scan-start]
2020-10-27T22:57:09.060-0800: [GC concurrent-root-region-scan-end, 0.0000333 secs]
2020-10-27T22:57:09.060-0800: [GC concurrent-mark-start]
2020-10-27T22:57:09.063-0800: [GC concurrent-mark-end, 0.0034425 secs]
2020-10-27T22:57:09.063-0800: [GC remark, 0.0019179 secs]
2020-10-27T22:57:09.065-0800: [GC cleanup 357M->357M(512M), 0.0005632 secs]
2020-10-27T22:57:09.082-0800: [GC pause (G1 Evacuation Pause) (young) 399M->368M(512M), 0.0061697 secs]
2020-10-27T22:57:09.097-0800: [GC pause (G1 Evacuation Pause) (mixed) 394M->362M(512M), 0.0100453 secs]
执行结束!共生成对象次数:6060
```


#### 作业六：（Week02 作业题目（周六））
``要求：写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 Github。
``

###### HttpURLConnection类：HttpURLConnection 获取类
```java
package org.geekbang.java.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description: 通过 url 地址获取 {@link HttpURLConnection}
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class URLConnectionResources {

    public static HttpURLConnection getUrlConnection(String httpUrl) {
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            return urlConnection;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

###### HttpClientSend类：发送方式接口
```java
package org.geekbang.java.httpclient;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public interface HttpClientSend {

    /**
     * get 提交方式
     * @param url
     * @return
     */
    String doGet(String url);

    /**
     * post 提交方式
     * @param url
     * @param param
     * @return
     */
    String doPost(String url, String param);

}
```

###### HttpClientUtils类：HttpClientSend 的实现类
```java
package org.geekbang.java.httpclient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import static org.geekbang.java.httpclient.URLConnectionResources.getUrlConnection;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class HttpClientUtils implements HttpClientSend {


    public String doGet(String url) {

        InputStream is = null;
        BufferedReader br = null;
        // 返回结果
        String result = null;
        HttpURLConnection connection = getUrlConnection(url);

        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(40000);
            connection.connect();

            if (connection.getResponseCode() == 200) {
                // 通过connection连接，获取输入流
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭远程连接
            connection.disconnect();
        }
        return result;
    }

    public String doPost(String url, String param) {

        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        HttpURLConnection connection = null;

        try {
            connection = getUrlConnection(url);

            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true
            // connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 key1=value1&key2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (
        MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }
}
```

##### MainTest: 测试类
```java
package org.geekbang.java.httpclient;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class MainTest {

    public static void main(String[] args) {
        HttpClientUtils hcu = new HttpClientUtils();
//        String res = hcu.doPost("https://www.baidu.com?tstmp="+Math.random(),"p=2");
        String res = hcu.doGet("http://localhost:8808/test");
        System.out.println(res);
    }
}
```
###### httpClient 执行结果：
```mysql based
get方式：hello,kimmking

post方式结果： 
<!DOCTYPE html>
    <!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');
          </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>
```

#### OkHttpDemo 类：OkHttp 的简单实现 Demo
```java
package org.geekbang.java.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class OkHttpDemo {
    
    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Response res;
        String url = "http://localhost:8808/test";
        Request req = new Request.Builder().url(url).get().build();
        try {
            res = okHttpClient.newCall(req).execute();
            System.out.println(res.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


