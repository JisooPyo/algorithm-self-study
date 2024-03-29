## Design the Key

이전 문제에서, 키의 선택은 비교적 간단하다. 불행하게도, 때때로 너는 해시 테이블을 사용할 때 알맞은 키를 디자인하는 것을 심사숙고해야 한다.

### An Example

> 주어진 문자열의 배열에서 아나그램을 함께 그룹화하라.

알다시피, Hash Map은 key로써 정보를 그룹핑하는데 매우 효과적이다. 하지만 우리는 원래 문자열을 key로써 직접적으로 사용할 수 없다. 아나그램의 타입을 표현하기 위해 적절한 key를 디자인해야 한다. 예를
들어, "eat"과 "ate"는 동일한 그룹에 속해야 한다. 그러나 두 문자열은 함께 그룹화되어서는 안된다.

### Solution

사실, key를 디자인하는 것은 원래 정보와 HashMap에서 쓰이는 실제 key사이에 관계를 스스로 매핑하는 것이다. key를 디자인할 때, 두 가지 조건을 만족하여야 한다.

> 1. 같은 그룹에 속한 모든 값들은 같은 그룹에 매핑될 것이다.
> 2. 다른 그룹으로 나눠질 필요가 있는 값들은 같은 그룹에 매핑되어서는 안 된다.

이 과정은 해시 함수를 디자인하는 것과 비슷하지만, 중요한 다른 접이 있다. 해시 함수는 첫 번째 규칙을 만족하지만, 두 번째는 만족하지 않아도 된다. 하지만 너의 매핑 함수는 두 가지 모두를 만족해야만 한다.

위의 예시에서, 우리의 매핑 전략은 다음이 될 수 있다.

> 문자열을 정렬한 뒤, 정렬된 문자열을 key로써 사용한다. 다시 말해서, "eat"과 "ate"은 "aet"에 매핑될 것이다.

매핑 전략은 때때로 정말 어려울 수 있다. 우리는 이 챕터에서 몇몇의 연습 문제를 제공하고 그 이후 요약본을 제공할 것이다.

### Design the Key - Summary

여기 key를 디자인하기 위한 몇 개의 요점이 있다.

1. 문자열이나 배열의 각 요소의 순서가 중요하지 않을 때, 너는 정렬된 문자열이나 배열을 key로써 사용할 수 있다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/28/screen-shot-2018-02-28-at-144518.png" width="500px">

2. 만약 각 값의 offset에 대해서만 신경쓴다면(보통 첫 번째 값으로부터의 offset), key로써 offset을 사용할 수 있다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/28/screen-shot-2018-02-28-at-144738.png" width="670px">

3. 가끔, 트리 구조의 경우, key로 TreeNode를 직접적으로 사용할 수 있다. 그러나 대부분의 케이스에서, subtree의 직렬화가 더 좋은 아이디어이다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/28/screen-shot-2018-02-28-at-143858.png" width="260px">

4. 행렬의 경우, row index나 column index를 key로 사용할 수 있다.

5. 스도쿠의 경우, 원소가 속해있는 블록을 확인하기 위해 row index와 column index를 섞을 수 있다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/28/screen-shot-2018-02-28-at-145454.png" width="250px">

6. 가끔, 행렬의 경우, 같은 대각선에 있는 값들을 모을 수 있다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/02/28/screen-shot-2018-02-28-at-140029.png" width="520px">