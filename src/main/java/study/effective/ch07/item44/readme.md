## 표준 함수형 인터페이스를 사용하라
* 람다의 출현으로 템플릿 메서드 패턴 인기 하락
  - template pattern
  ![](template.png)
  - command strategy.png
  ![](command_strategy.png)
* 함수 객체를 받는 정적 팩터리나 생성자를 제공해야함
* LinkedHashMap - removeEldestEntry (code)
```
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > 100;
    }
```


