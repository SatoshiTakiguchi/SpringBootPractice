### Q4ブランチとQ5ブランチはそれぞれ課題番号と逆になってます  
#### Q4
テスト(結合テストも混じりました)
#### Q5
BootStrap

#### Q6  結合テスト
- CombinedTes  
  単体テストを順番に並べただけ
- CombinedTest3  
  WebTestClientで単体テストを順番にならべた

## メモ
### 起動

### テスト
docker-compose exec app bash  
./gradlew test (--tests *クラス名)  
結合テスト  
./gradlew test --tests * Controller *  
単体テスト  
./gradlew test --tests *CombinedTest  

