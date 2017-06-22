# KotlinDemo
开始使用Android和Kotlin

本教程将引导我们使用android Studio为Android创建一个简单的Kotlin应用程序。

安装Kotlin插件 
Android Studio3.0版本自带Kotlin插件。如果您使用的是较早版本，则需要安装Kotlin插件。 
在Android Studio中打开Settings，选择Plugins选项，点击Browse Repositories，在打开的新窗口中搜索Kotlin，安装。
![安装](http://img.blog.csdn.net/20170518124842835?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzU2NjA1Nzc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
创建一个项目

开始使用Kotlin进行Android开发是非常容易的。在本教程中，我们将使用Android Studio进行升级。如果使用Intellij IDEA与Android，这个过程几乎是一样的。

首先让我们创建一个新的项目。选择开始一个新的Android Studio项目或文件| 新建项目。以下对话框将引导您完成新项目创建过程。您需要为项目命名，并选择您安装的Android SDK版本。大多数选项可以保留其默认值，因此您可以按“Enter”几次。
Android Studio 3.0提供了一个选项，可以在此屏幕上启用Kotlin支持。您可以检查此选项，并跳过下面的“在项目中配置Kotlin”。
在Android Studio 3.0中，您可以选择立即在Kotlin中创建活动，因此您可以跳过“将Java代码转换为Kotlin”步骤。早期版本将在Java中创建一个活动，您可以使用自动化转换器工具进行转换。

一般来说，开始使用Kotlin的最简单方法是将Java活动自动转换为Kotlin。请注意，无论何时，通过文档查找文档以表达旧模式，您可以使用Java编写它，然后将Java代码复制粘贴到Kotlin文件中，IntelliJ IDEA（或Android Studio）将建议将其转换。

将Java代码转换为Kotlin

打开MainActivity.java文件。然后调用动作将Java文件转换为Kotlin文件。你可以通过几种方法来实现。最简单的一个是调用Find Action并开始输入一个动作名称（如下面的截图）。或者，您可以通过代码|调用此选项 将Java文件转换为Kotlin文件 菜单项或使用相应的快捷方式（您可以在菜单项中找到它）。
![ad1](http://kotlinlang.org/assets/images/tutorials/kotlin-android/convert-java-to-kotlin.png)
转换后
![ad](http://kotlinlang.org/assets/images/tutorials/kotlin-android/converted-code.png)
在项目中配置Kotlin

如果您开始编辑此文件，Android Studio会向您显示Kotlin未配置的提示，因此可以对其进行配置。或者，您可以通过选择工具|来调用配置 Kotlin | 在主菜单中配置项目中的Kotlin。
![a](http://kotlinlang.org/assets/images/tutorials/kotlin-android/kotlin-not-configured.png)
然后系统提示您输入Kotlin版本。从安装版本列表中选择最新版本。
![a](http://kotlinlang.org/assets/images/tutorials/kotlin-android/configure-kotlin-in-project-details.png)
配置Kotlin后，应该更新应用程序的build.gradle文件。现在你可以看到应用插件：'kotlin-android'和kotlin-stdlib依赖项被添加。
![a](http://kotlinlang.org/assets/images/tutorials/kotlin-android/sync-project-with-gradle.png)
最后一件事是同步项目。您可以在提示中按“同步立即”或使用Gradle文件调用同步项目。
![a](http://kotlinlang.org/assets/images/tutorials/kotlin-android/sync-project-with-gradle-2.png)
构建和发布适用于Android的Kotlin应用程序

您现在可以构建应用程序并在仿真器或设备上运行它。这与Java中的工作方式完全相同。您可以发布应用程序，并以类似于使用Java编写的Android应用程序的方式进行签名。

Kotlin有一个相当小的运行时文件大小：库大约是859KB（从1.1.2-5开始）。这意味着Kotlin对.apk文件大小增加了一点。

Kotlin编译器生成字节代码，因此在Kotlin应用程序与Java编写的应用程序的外观和感觉上确实没有区别。

## Kotlin Android扩展

本教程介绍如何使用Kotlin Android Extensions来改进对Android开发的支持。 

在本教程中，我们将介绍使用Kotlin Android Extensions插件所需的步骤，增强Android的开发体验。

背景

每个Android开发人员都知道这个findViewById()功能。毫无疑问，这是一个难以阅读和支持的潜在错误和令人讨厌的代码的来源。虽然有几个可用的库可以为此问题提供解决方案，但依赖于运行时的库，它们需要为每个库注释字段View。

Kotlin Android Extensions插件允许我们获得与这些库中的一些相同的体验，而无需添加任何额外的代码或运送任何额外的运行时。

实质上，这将允许以下代码：

```Java 
// Using R.layout.activity_main from the main source set
import kotlinx.android.synthetic.main.activity_main.*

class MyActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setText("Hello, world!")
        // Instead of findViewById(R.id.textView) as TextView
    }
}
```
textView是一个扩展属性Activity，它的声明类型相同activity_main.xml。

### 使用Kotlin Android扩展

#### 配置依赖关系

在本教程中，我们将使用Gradle，但可以使用IntelliJ IDEA项目结构或Maven完成相同的操作。有关设置Gradle与Kotlin一起工作的详细信息，请参阅使用Gradle。

Android扩展程序是Kotlin IDEA插件的一部分。您不需要安装其他插件。

您所需要的是在项目本地build.gradle文件中启用Android Extensions Gradle插件：
``` Java
apply plugin: 'kotlin-android-extensions'
```

因此，如果布局文件名是`activity_main.xml`，我们将导入`kotlinx.android.synthetic.main.activity_main.*`。

如果我们要调用合成属性View（在适配器类中有用），我们也应该导入`kotlinx.android.synthetic.main.activity_main.view.*`。

一旦我们这样做，我们可以调用相应的扩展名，这些扩展名是XML文件中的视图后面命名的属性。例如，对于这个视图：
``` xml
<TextView
  android:id="@+id/hello"
  android:layout_width="fill_parent"
  android:layout_height="wrap_content"
  android:text="Hello World, MyActivity"/>
```
将有一个名为的属性hello：
``` java
activity.hello.setText("Hi!")
```
#### Android Flavors
`Android Extensions`插件支持`Android`风格。假设你`free`的`build.gradle`文件中有一个风味：
```
android {
    productFlavors {
        free {
            versionName "1.0-free"
        }
    }
}
```
因此，您可以`free/res/layout/activity_free.xml`通过添加此导入来导入布局的所有合成属性：
```Java
import kotlinx.android.synthetic.free.activity_free.*
```
#### 在引擎盖下
Kotlin Android Extensions是Kotlin编译器的插件，它有两件事情：
    1,在每个Kotlin内添加一个隐藏的缓存功能和一个字段Activity。该方法很小，所以它不会增加APK的大小。
    2,用函数调用替换每个合成属性调用。
这是如何工作的，当调用合成属性时，接收方是模块源中的Kotlin Activity / Fragment类，缓存函数被调用。例如，给定
```Java
class MyActivity: Activity()
fun MyActivity.a() { 
        this.textView.setText(“”) 
}
```
MyActivity内部生成一个隐藏的缓存功能，所以我们可以使用缓存机制。

但在以下情况下：
```Java
fun Activity.b() { 
        this.textView.setText(“”)     
}
```
我们不知道这个函数是否仅在我们的来源的活动或普通Java活动中被调用。因此，即使上一个示例中的MyActivity实例是接收器，我们也不使用缓存。







