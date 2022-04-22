# MVVM 아키텍처를 적용한 Todo List


## 💻 Use Stack 
<img alt="Android" src ="https://img.shields.io/badge/Android-3DDC84.svg?&style=for-the-badge&logo=Android&logoColor=white"/> <img alt="Android" src ="https://img.shields.io/badge/Kotlin-7F52FF.svg?&style=for-the-badge&logo=Kotlin&logoColor=white"/>

<br/>

## 📖 상세 내용

<div align="center">
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1e3ce118-88ea-4b2e-b625-572263978b2a/Screenshot_1624951653.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024708Z&X-Amz-Expires=86400&X-Amz-Signature=97574cf4780bdc20ec0dc6c5a5019935b9d210c6d6c528a38908009e87b626e9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951653.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/188c719d-938a-4ca2-b6ac-ae52fa5e76c6/Screenshot_1624951658.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024709Z&X-Amz-Expires=86400&X-Amz-Signature=60b76deda28acc00231cd06b3601710235efc5b22b1b9e5a3602d0298e359b2b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951658.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/354ad3e9-5bbf-4aa0-b02f-2f63261907c8/Screenshot_1624951732.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024712Z&X-Amz-Expires=86400&X-Amz-Signature=b6f024b2b94b5a2da39194f02856b5e8928c3a55a91af81605343a32fbce26c1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951732.png%22&x-id=GetObject" width="30%" >
</div>

<div align="center">
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4dc2ee9b-10f0-4905-b658-ae0fbae6bff1/Screenshot_1624951778.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024713Z&X-Amz-Expires=86400&X-Amz-Signature=81e5ac67728bc5161fc4aa2dc66474807c13344c6bdc5e5fedaa333fd4107981&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951778.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/628d7abd-e84b-40df-a7fa-8cbb5781117b/Screenshot_1624951737.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024715Z&X-Amz-Expires=86400&X-Amz-Signature=b6cf3980ee6ec155cdaed4f4d262c88a16d929ff4615882c3f14da05f901ba42&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951737.png%22&x-id=GetObject" width="30%" >
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d74f0715-9804-468f-beca-579ed5eda93c/Screenshot_1624951800.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024716Z&X-Amz-Expires=86400&X-Amz-Signature=11187c3edcf47884983154d6c0f29a8ff3cf75a998e68c24a68a370cb537130b&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot_1624951800.png%22&x-id=GetObject" width="30%" >
</div>

<div align="center">
  <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9860ac72-259b-40ef-8b29-50b4de4c1a3f/todo_%EB%A6%AC%EC%8A%A4%ED%8A%B8_%EC%95%B1.gif?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220422%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220422T024719Z&X-Amz-Expires=86400&X-Amz-Signature=55217bee106507d679e426b89c565e572829933168ac6569e970cf85986634c9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22todo%2520%25EB%25A6%25AC%25EC%258A%25A4%25ED%258A%25B8%2520%25EC%2595%25B1.gif%22&x-id=GetObject" width="35%" >
</div>

<br/>
<br/>

> 🍽️ 해당 프로젝트는 **Fastcampus 의  Android with Kotlin - Advanced(part5) - Ch01 TodoList 강의**를 보며 진행한 프로젝트입니다.

<br/>
<br/>


## 🛠️ 사용 라이브러리

- Room
- Koin
- Coroutines
- LiveData, ViewModel
- Test-Driven-Development

<br/>
<br/>


## 📱 구현한 기능

- MVVM 아키텍처 방식으로 구현
- TDD 방식을 적용하여 코드 작성
- Todo List 및 새로고침
- Todo List 전체 삭제 기능
- Todo 생성, 수정 및 삭제

<br/>
<br/>



## 💡 참고한 문서

아키텍처 구조 MVP, MVVM

- Guide to app architecture [ [URL](https://developer.android.com/jetpack/guide) ]
- 클릭 아키텍처란 [ [URL](https://blog.coderifleman.com/2017/12/18/the-clean-architecture/) ]
- The lifecycle of a ViewModel [ [URL](https://developer.android.com/topic/libraries/architecture/viewmodel#lifecycle) ]
- 안드로이드 권장 아키텍처에 대해서 [ [URL](https://velog.io/@ausg/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B6%8C%EC%9E%A5-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C-MVVM-%ED%8C%A8%ED%84%B4%EA%B3%BC-%EB%B9%84%EC%8A%B7) ]
- Android 아키텍처 비교–MVP, MVVM, SVC–1 [ [URL](https://medium.com/@bansooknam/android-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%EB%B9%84%EA%B5%90-mvp-mvvm-svc-1-f24e5f338523) ]
- 안드로이드 아키텍처 패턴 - MVC가 뭘까? [ [URL](https://velog.io/@jojo_devstory/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90-%ED%8C%A8%ED%84%B4-MVC%EA%B0%80-%EB%AD%98%EA%B9%8C) ]
- 안드로이드 아키텍처 패턴 - MVP가 뭘까? [ [URL](https://velog.io/@jojo_devstory/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%ED%8C%A8%ED%84%B4-MVP%EA%B0%80-%EB%AD%98%EA%B9%8C) ]
- 안드로이드 아키텍처 패턴 - MVVM이 뭘까? [ [URL](https://velog.io/@jojo_devstory/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%ED%8C%A8%ED%84%B4-MVVM%EC%9D%B4-%EB%AD%98%EA%B9%8C) ]
- [Android & Coroutine] ViewModelScope, LiveData Builder 사용하기 [ [URL](https://zion830.tistory.com/64) ]
- ViewModel  [ [URL](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel) ]
- Easy Coroutines in Android: viewModelScope [ [URL](https://medium.com/androiddevelopers/easy-coroutines-in-android-viewmodelscope-25bffb605471) ]
- Use Kotlin coroutines with Architecture components [ [URL](https://developer.android.com/topic/libraries/architecture/coroutines#viewmodelscope) ]

Koin & Di

- Dependency injection in Android [ [URL](https://developer.android.com/training/dependency-injection) ]
- Koin 퀵스타트 JUnit Tests && Android ViewModel [ [URL](https://insert-koin.io/docs/quickstart/junit-test) ]
- 안드로이드 앱에 Koin 으로 Di 적용하기 [ [URL](https://spoqa.github.io/2020/11/02/android-dependency-injection-with-koin.html) ]
- [Design pattern] DI (Dependency Injection) - 의존성 주입 [ [URL](https://jaejong.tistory.com/123?category=873925) ]
- Koin 기본 사용 방법 [ [URL](https://jaejong.tistory.com/153) ]
- Koin #2 - 자세히 알아보기 Definitions [ [URL](https://jaejong.tistory.com/154?category=888864#Definitions) ]
- Koin 잘 사용하기 [ [URL](https://medium.com/hongbeomi-dev/koin-%EC%9E%98-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-5a96a8bb94d3) ]

기타

- The one and only object [ [URL](https://wooooooak.github.io/%EB%B2%88%EC%97%AD%ED%95%98%EB%A9%B0%20%EA%B3%B5%EB%B6%80%ED%95%98%EA%B8%B0/2021/03/30/The-one-and-only-object/) ]
- 코틀린 invoke 함수 [ [URL](https://wooooooak.github.io/kotlin/2019/03/21/kotlin_invoke/) ]
- [DroidKnights 2019 - Track 2] 장선옥 - Android Project with Multi Module  [ [URL](https://www.youtube.com/watch?v=H4qh0n9Zu5k) ]
- 안드로이드 멀티 모듈 Android Multi Module [ [URL](https://footcode.postype.com/post/3673100) ]
- TDD 기반 개발 방법이란? [ [URL](https://gmlwjd9405.github.io/2018/06/03/agile-tdd.html) ]

<br/>
<br/>

