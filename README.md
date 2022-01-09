AdMobとNendメディエーション広告のネイティブ(Large-Wide)広告を試すために作成したアプリ。 

まず、AdMobに登録して、アプリを登録し、ネイティブ広告の広告ユニットIDを作成しておきます。　
次に、このプロジェクトのソースに対して以下を行います。

 - app/src/main のAndroidManifest.xmlの
 ```xml
<meta-data
      android:name="com.google.android.gms.ads.APPLICATION_ID"
      android:value="ca-app-pub-3940256099942544~3347511713" />
```
の`android:value`の値を自分のadMobプロジェクトのアプリケーションIDにする
 
 - src/main/java/com/kkkkan/nendadresearch/Util.kt の `largeAdUnitId`の値を自分のadMobプロジェクトのネイティブ広告の広告ユニットIDにする
 - src/main/java/com/kkkkan/nendadresearch/Util.kt の `testDeviceId`の値を実行する端末のデバイスID(logcatにAdMob SDKが表示してくれるもの https://developers.google.com/admob/android/test-ads?hl=ja)にする


以上を終わらせたうえでAdMobのコンソールからメディエーショングループを作成し、Nend広告を追加して、ネイティブ（Large-Wide）のspotIDとapiKeyを登録します。 

<参考> 

 - https://github.com/fan-ADN/nendSDK-Android/wiki/%E3%83%86%E3%82%B9%E3%83%88%E8%A1%A8%E7%A4%BA%E3%82%92%E8%A1%8C%E3%81%86#android%E3%82%A2%E3%83%97%E3%83%AA%E5%90%91%E3%81%91%E8%A1%A8%E7%A4%BA%E3%83%86%E3%82%B9%E3%83%88%E7%94%A8id 
 - https://developers.google.com/admob/android/mediation/nend#kotlin

念のため、NendのeCPMは$1000などとても高い値にしておいてください。

以上でnend広告を表示できるようになります。