# Java Final Project

## Music Player Project

### 인터페이스

![image-20180522193528004](/var/folders/g0/81jqbcd530b3xz038x5yrcd40000gn/T/abnerworks.Typora/image-20180522193528004.png)

### 기능

#### Playing song function

- mp3포맷

- icon 

- play, pause (재생, 일시정지 화면전환), stop, next, previous 

  by 클릭 + Ctrl+keyboard //keylistener?? accelerator

  단축키:

  Ctrl + P to pause/play, Ctrl + S to stop, Ctrl + B to play previous song, Ctrl + F to play next song.

  재생시간 및 위치(업데이트), 제목, 아티스트. 볼륨

#### Playlist function

- playlist 파일 포맷 = txt

  ex)

  In the end; Linkin Park; c:\music\in_the_end.mp3

  Try; Pink; c:\music\try.mp3

- 플레이리스트에 노래 보이기 (extra : 재생노래 color)

  제목, 아티스트, 재생시간

  노래목록 스크롤 가능

  지울 때 한꺼번에 가능

- 파일 열기(Open file)

  `Open file` : 새로운 플레이리스트 생성 후 거기에 선택한 곡 1개 추가

- 노래 추가(Add song)

  `Add song` : 플레이 리스트에 추가 .mp3 파일만 보여줌!

- 노래 삭제(Remove song)

  `Remove song` : 노래 선택(ctrl이용해 복수선택 가능) 후 삭제

- 플레이리스트 추가

  `New playlist` : 현재 플레이리스트를 닫고 노래 안보이게

  .playlist 확장자로 만들기

- 플레이리스트 열기

  `Open playlist` : dialog box에서 플레이리스트 선택

  .playlist확장자 파일만 보이기

- 플레이리스트 저장

  `Save playlist` : 재생 목록이 새로운 재생 목록인 경우, 열려 있는 JFileChooser파일 경로 선택 후 저장

- 현재 플레이리스트 삭제

  `Remove playlist` : .playlist파일 삭제

![image-20180523120508939](/var/folders/g0/81jqbcd530b3xz038x5yrcd40000gn/T/abnerworks.Typora/image-20180523120508939.png)

import library

### hint

- .mp3 재생시 Java Media Foundation (JMF) library 이용

- 멀티쓰레드

  ​

### 가산점

- 보기 좋은 화면

- 추가 기능

  - 시작시간 변경가능
  - 노래 위치 변경

- 오류제어:

  - 잘못된 확장자 열때 (Open file)
  - 플레이리스트에 없는 파일을 열 때 (로컬에 없을 경우,,?)

- 더 많은 확장자명 지원

- Look-and-Feel GUI

  setting -> swing -> look and feel -> Apply choose lookandfeel in main()