# 마인미

![image](https://github.com/NaJuDoRyeong/mineme_AOS_new/assets/109224863/91100610-2cfa-434c-9cb9-c5ecaf106e13)


## 🌸 프로젝트 소개

소중한 연인과의 추억을 기록해 보세요 🥰

위치와 날짜를 기반으로 사진을 기록해요 😎

위치와 날짜를 기반으로 추억을 모아볼 수 있어요 ☺

## 👩‍💻 개발자

<div align="center">

| iOS | AOS | BE | BE |
| --- | --- | --- | --- |
| [김민령](https://github.com/sladuf) | [김도우](https://github.com/KDW03) | [이주원](https://github.com/jujuwon) | [정금종](https://github.com/Floodnut) |

</div>

## 🛠️ 아키텍처

<img width="850" alt="Untitled" src="https://github.com/NaJuDoRyeong/mineme_AOS_new/assets/109224863/2941a9fb-93f9-4d65-948f-ba2d1ee19afc">


**Mineme**는 [앱 아키텍처 가이드](https://developer.android.com/topic/architecture)를 따릅니다.

전체 구조는 UI Layer과 Data Layer, 두 부분으로 이루어져 있습니다. 각 계층은 자신만의 요소들을 가지고 특정 역할을 합니다. 화살표는 한 요소가 다른 요소에 의존한다는 것을 나타냅니다.

### **📌 아키텍처 개요**

<img width="569" alt="Untitled" src="https://github.com/NaJuDoRyeong/mineme_AOS_new/assets/109224863/b14886db-d8b8-498b-a676-376ee5c21834">


기본적으로 [단방향 이벤트/데이터 흐름](https://developer.android.com/topic/architecture/ui-layer#udf)을 따릅니다

### 예시 : App 시작 후 HomeScreen 데이터 표시

아래 제시된 그림은 **MinemeApp** Cold Start후 HomeScreen 데이터 표시가 일어날 때 까지의 사용자 인터페이스(UI)와 데이터 처리 과정을 상세하게 나타내고 있습니다. 이 설명은 `prod` 플레이버를 기반으로 하며, 사용자가 유효한 `JWT`(Json Web Token)를 보유하고 있는 상황을 전제로 합니다

<img width="1819" alt="image" src="https://github.com/NaJuDoRyeong/mineme_AOS_new/assets/109224863/657fd8a0-49f8-4a7d-bee1-310dee857941">




## 🪧 모듈화

![Untitled](https://github.com/NaJuDoRyeong/mineme_AOS_new/assets/109224863/7fd308e5-d68d-421b-8d0a-cda2fda10cbc)


### **📌 Modules Overview**

- **app:Module** - 앱의 기본 구조와 주요 클래스(예: `MainActivity`, `DoApp`)를 포함하며, 앱 내의 다른 코드들을 연결합니다. 예로 `DoNavHost`로 내비게이션을 설정하거나 `TopLevelDestination`으로 하단 내비게이션 바를 설정합니다. 이 모듈은 모든 `feature` 모듈과 필요한 `core` 모듈에 의존합니다.
- **feature:Module** - 특정 기능을 담당하는 모듈입니다. 필요할 때 다양한 앱에서 재사용 가능하며, 독립적으로 유지됩니다. 한 클래스가 특정 `feature` 모듈에만 필요하면 그 안에 둬야 합니다. 그렇지 않으면 `core` 모듈로 옮겨야 합니다. `feature` 모듈은 다른 `feature` 모듈에 의존하면 안 되며, `core` 모듈에만 의존해야 합니다.
- **core:Module** - 앱 내에서 공통적으로 사용되는 부분들을 담은 라이브러리 모듈입니다. 다른 `core` 모듈에는 의존할 수 있지만, `feature`이나 `app` 모듈에는 의존하면 안 됩니다.

## 🧪 Testing

**Mineme**는 `Hilt`를 사용한 DI로 testing을 쉽게 합니다.

- 데이터 컴포넌트는 인터페이스로 정의됩니다.
- Testing에서는 실제 mocking library 대신 Hilt의 testing API를 활용하여 production implementations를 test doubles로 교체합니다.

예시)

- Instrumentation tests에서, 사용자의 preferences를 임시 폴더에 저장한 후, 테스트가 끝나면 삭제합니다. 이렇게 함으로써 real DataStore의 동작을 모두 테스트할 수 있습니다.
- Test versions의 repositories는 standard repositories와 같은 기능을 제공하며, 추가적인 testing hooks도 제공합니다. 이를 통해 ViewModel의 behavior를 검증합니다.

## 🖥️ UI

**Mineme**는 [Material 3 가이드라인](https://m3.material.io/)을 사용하여 디자인되었습니다.

- 모든 UI 요소는 Jetpack Compose로 구축되었습니다.
- 두 가지 테마를 지원합니다. (각 테마는 다크 모드를 지원합니다.)
    - **동적 색상** - 사용자의 현재 색상 테마를 기반
    - **기본 테마** - 동적 색상을 지원하지 않을 때

## ©️ License

```
 Copyright 2023 KDW03
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```

## 📚 개발로그
