---

tags: Android
title: 如何發布至 Jcenter 倉庫？

---


註冊 [Bintray](https://bintray.com/signup) 帳號


![](https://i.imgur.com/27Q2eRI.png)


建議使用 GitHub 註冊，再填寫郵箱等基本資料即可登入

![](https://i.imgur.com/aNpxco2.png)


選擇 『Add New Repository』，添加一個新的倉庫

![](https://i.imgur.com/gJF1aPF.png)

- Name：maven
- Type：Maven


![](https://i.imgur.com/tX2SOPF.png)


選擇『Add New Package』創建一個包

![](https://i.imgur.com/qJLgJ6w.png)

- Name：項目的名稱
- Description：項目的描述
- Licenses：項目的許可證
- Version control：GitHub 的開源地址


進入『Edit Your Profile』，選擇『API Key』

![](https://i.imgur.com/ZATMPZx.png)

將 API Key 填入 local.properties內

![](https://i.imgur.com/chwg4YL.png)

- bintray：API Key
- bintrayUser：User Name

此文件是存放本地的目錄，由於它的特性不會被傳至遠端倉庫，放此可防止不小心上傳自己的 Key


開啟根目錄下的 build.gradle

![](https://i.imgur.com/KFm46z4.png)

```
dependencies {
        ...
        classpath 'com.novoda:bintray-release:0.9.1'
        ...
    }

```

開啟要發布的 module 下的 build.gradle，填入以下的內容

![](https://i.imgur.com/yDel0CG.png)


```
apply plugin: 'com.novoda.bintray-release'

Properties properties = new Properties()
properties.load(project.rootProject.file('local.properties').newDataInputStream())
def bintrayUserVal = properties.getProperty('bintrayUser')
def bintrayKeyVal = properties.getProperty('bintrayKey')

publish {
    userOrg = 'gtfdeyouxiang'  //jcenter的用户名
    groupId = 'top.gtf35.lib.withyebai'    //组织id
    artifactId = 'BeautifulSwitch'    //libName
    publishVersion = '1.1'        //libVersion
    desc = 'an beautiful switch on Android'//lib desc
    website = 'https://github.com/gtf35/beautiful_switch' //lib的地址
    bintrayUser = bintrayUserVal //上面task中读取到的jcenterName
    bintrayKey = bintrayKeyVal //上面task中读取到的apiKey
    dryRun = false
}
```


打開右側的 gradle 標籤，執行 bintrayUpload 將之上傳至 Jcenter 倉庫

![](https://i.imgur.com/uqgSxyX.png)


選擇『Add to JCenter』

![](https://i.imgur.com/IW6KBE6.png)
