# Constraint Layout
의도한 모습대로 앱이 동작해야 함  
시각적 청사진(blueprint)로 만들 수 있는 Constraint Layout을 추론하고 추가해 보자.

## 중첩 Layout은 비효율적일 수 있음
LinearLayout과 FrameLayout을 적절하게 중첩하면 복잡한 UI를 구현할 수 있지만,  
앱이 느려지고, 코드의 가독성과 유지보수가 떨어지는 문제가 생길 수 있음.  
Android가 Device Screen에 Layout을 출력 할 때는 각 View가 위치해야 할 곳을 계산하려고 View 계층도를 생성함.  
더 많을 View와 다양한 중첩된 뷰, 깊은 계층이 있다면,  
계층도가 복잡해 지고, 성능에 장애가 되고, 코드가 복잡해 지므로 유지보수가  어려워 질 수 있음.  

## Constraint Layout
Constraint Layout은 Linear Layout이나 Frame Layout보다 더 복잡하지만 더 유연함.  
중첩을 사용할 필요성이 없어지고, 더 평면적인 View 계층도가 되므로 더 복잡한 UI에 적합함.

### 시각적으로 Constraint Layout을 설계할 수 있음

### 핵심 정리
- Constraint Layout은 Android Studio의 Design 편집기에서 작동하도록 만들어 졌음.  
  Constraint Layout은 별도의 라이브러리로 제공되고 최소 SDK가 API 9 이상인 Application에서만 사용 가능함
- Constraint Layout을 추가해서 View의 위치시킬 수 있음.  
  각 뷰는 최소 한 개의 수평 Constraint를 포함해야 함.
- View의 양쪽 면에서 Constraint를 추가해서 View를 가운데 배치할 수 있음.  
  View의 Bias를 조절해서 Constraint에서 위치를 조절할 수 있음.
- View가 양쪽 면에 Constraint를 가지고 있다면, View의 크기가 Constraint의 크기와 같도록 만들 수 있음.
- View의 크기를 너비 : 높이의 비율로 지정할 수 있음.
- Infer Constraints 버튼을 누르면 Blueprint에서 현재 뷰의 위치에 따라 자동으로 Constraint가 추가 됨.