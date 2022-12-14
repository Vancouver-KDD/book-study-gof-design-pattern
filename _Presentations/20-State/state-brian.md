<style>
red { color: red }
yellow { color: yellow }
blue { color: blue }
green { color: green }
</style>

# State

### ๐ ์ธ์ ๊น์ง if else ๋ก ๋ชจ๋  ์ํ ๊ด๋ฆฌ๋ฅผ ํ ๊ฒ์ธ๊ฐ?!
![](images/callback_hell.png)

## State Pattern: ๊ฐ์ฒด ๋ด๋ถ <ins>์ํ ๋ณ๊ฒฝ</ins>์ ๋ฐ๋ผ ๊ฐ์ฒด์ <ins>ํ๋์ด ๋ฌ๋ผ์ง๋</ins> ํจํด
* ์ํ์ ํนํ๋ <red>ํ๋๋ค์ ๋ถ๋ฆฌํด</red> ๋ผ ์ ์์ผ๋ฉฐ, <yellow>์๋ก์ด ํ๋</yellow>์ ์ถ๊ฐ ํ๋๋ผ๋ ๋ค๋ฅธ ํ๋์ <green>์ํฅ์ ์ฃผ์ง ์๋๋ค</green>.

### If statement / Switch Case statement ์์ 
```
Class StudyCourse {
    enum CourseState {
        DRAFT, RRIVATE, PUBLIC
    } 

    CourseState state;
    Set<Student> students;
    List<String> reviews;
    
    public List<String> getReviews(Student student) {
        switch (state){
            case DRAFT: 
            case PRIVATE: 
                if(students.contain(student)) return reviews; 
            case PUBLIC: return reviews;
            default:
                 return Collections.emptyList();
        }
    }  
}
```
### ๋ฌธ์ ์ 
* CourseState ๊ฐ ํ๋ ๋์ด๋  ๋๋ง๋ค ๊ธฐ์กด ์ฝ๋์ธ getReviews ํจ์๋ฅผ ๋ณ๊ฒฝ ํด์ผํจ

### ๊ฐ์  ์ฝ๋
```
Class StudyCourse {

    CourseState state;
    Set<Student> students;
    List<String> reviews;
    
    public void setState(CourseState state) {
        this.state = state;
    }
    
    public List<String> getReviews(Student student) {
        return state.getReviews(stduent);
    }
}
```

## Class Diagram
![](images/state_diagram.png)

## Implementation
![](images/package.png)

## Pros and cons
* Pros
  * ์ํ์ ๋ฐ๋ฅธ ๋์์ ๊ฐ๋ณ ํด๋์ค๋ก ์ฎ๊ฒจ์ ๊ด๋ฆฌ (Single Responsibility)
    * unit test ๊ด๋ฆฌ๊ฐ ์ฌ์์ง
  * ๊ธฐ์กด์ ํน์  ์ํ์ ๋ฐ๋ฅธ ๋์์ ๋ณ๊ฒฝํ์ง ์๊ณ  ์๋ก์ด ์ํ๋ฅผ ์ถ๊ฐ ํ  ์ ์๋ค. (Open-Closed)
  * ์ฝ๋์ ๋ณต์ก๋๋ฅผ ์ค ์ผ ์ ์๋ค.
* Cons
  * ๊ฐ๋จ ํ ์ฝ๋์ ์ ์ฉํ๋ฉด ํด๋์ค์ ์ฝ๋๊ฐ ๋์ด๋๋ค.
  * context ๋ฅผ ์๋ชป ๊ด๋ฆฌํ๋ฉด method call ํ ๋ cycle ์ด ์๊ธธ ์ ์๋ค.