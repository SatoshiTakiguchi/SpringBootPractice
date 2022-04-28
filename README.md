### Q4ブランチとQ5ブランチはそれぞれ課題番号と逆になってます  
#### Q4
テスト
#### Q5
BootStrap


## 困っていること
#### POSTのテストがうまくいきません
具体的には、ContactTest.javaの51行目  
.flashAttr("contact_form", contact_form2)  
がうまくいっていないように思われます。  
.andExpect(model().attribute("contact_form", contact_form1)) (55行目)  
でフォームの属性がnullであるためテスト失敗と出るからです。  
55行目はコメントにすると成功するので動作自体は問題ないと思ってます。 

  
梅澤さんのコードも参考にしたのですが、特に目立った違いがなく、原因が不明です。  
よろしくお願いします。

## メモ
### 起動
docker-compose exec app java -jar build/libs/SpringBootApp-0.0.1-SNAPSHOT.jar
### テスト
./gradlew test (--tests *クラス名)

