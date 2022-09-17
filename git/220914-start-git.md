# 벽타는 개발자의 공부기록


2202.09.14(수)


1. git/github 강의(최우영강사님)

- Kernel 이란?
   - 하드웨어와 응용프로그램을 이어주는 운영체제의 핵심 시스템소프트웨어

- Shell 이란?
   - 운영체제의 커널과 사용자를 이어주는 소프트웨어  (예)bash, zsh 등

2. Shell Command

- cd : change directory (디렉토리를 변경)
- mkdir dev : dev라는 이름의 디렉토리(폴더) 생성
- touch TIL.md : 확장자md인 TIL 파일 생성
 - touch명령어로 생성 가능한 파일은 텍스트 기반 파일만 가능
- rm README.txt : README 텍스트 파일을 삭제
 - remove와 delete의 차이를 구별하기!
 - remove : 해당 파일에 접근하는 방법을 삭제
 - delete : 물리적으로 삭제
- vi readme.md : readme.md 파일 작업 실행
- cat readme.md : readme.md 파일에 저장된 내용을 출력
- mv readme.md ./README.txt : readme.md 파일을 README.txt파일로 옮김
- mv 옮길파일 옮길폴더
   - mv ../파일명 . : 상위 폴더의 파일을 현재 폴더로 이동

1. Vim command

- h j k l : left, down, up, right
- i : insert mode
- v : visual mode
- esc : back to normal mode
- d : delete
- dd : delete a line
- y : yank(복사)
- yy : yank a line
- p : paste
- u : undo
- :q - quit
- :q! - quit discarding all changes
- :w - write(저장)
- :wq - write and quit(저장 후 종료)

## git 환경설정
- git config -global user.name "유저네임"
- git config -global user.email "메일주소"
- git config -global core.eidtor "vim"
- git config -global core.pager "cat"

## git의 사용 과정
- git add -> git commit -> git push(origin main) 순
- git status : 현재 상태를 표시
- git add : working directory에서 작업한 것을 stage로 보냄
- git commit : 작업한 파일에 대한 설명등과 함께 localrepo로 보냄(스냅샷개념)
- git push : remote repository로보냄
- vi로 파일을 수정하고 add, commit, push 과정을 통해 깃허브에 반영
- personal token 생성 및 사용

## Conventional Rules
- feat: 기능 개발 관련
- fix: 오류 개선 혹은 버그 패치
- docs: 문서화 작업
- test: test 관련
- conf: 환경설정 관련
- build: 빌드 관련
- ci: Continuous Integration 관련

    *commit 할때 제목과 내용은 간략하면서도 구성을 파악하기 쉽도록 작성!

## .gitignore
- vi로 작성할때 무시할 특징을 정함
- gitignore.io에서 필요한 환경을 검색하고 해당 내용을 복사해와서 설정

### 숨김폴더에 대한 내용까지 확인 하는 명령어
- git status -uall

## Branch의 개념
- Branch는 말 그대로 '가지'라는 뜻
- git branch : branch가 뭐뭐 있는지 확인
- git branch {movie} : movie라는 branch를 생성
- git switch {branch명} : 이를 통해 branch 이동 후 작업 가능
 - switch는 예전에 checkout 이었음
- git branch -D {branch명} : 해당 branch를 삭제
- merge : branch 끼리의 병합
 - 병합은 주류 branch로 위치를 옮긴 뒤, 합칠 branch명을 기입
 - ex) git merge movie
 - merge할때 같은 부분을 수정했다면 merge conflict 발생
  - vi를 통해 수정(내가 최종적으로 수정하고자 하는 내용으로! 오류를 표시하는 자동 기입 내용들도 삭제)

## 추가로 알게 된 내용
### - Bash에서 파일을 remove한 사항이 깃허브에 반영되지 않을 때
- (예시) rm menus.md : menus파일을 remove
    - git add . : 현재 상태를 stage area로 보냄
    - git commit : stage에 보낸 것을 localrepo로 보냄
    - git push origin main : 깃허브와 동기화<br/>
    -> 깃허브에서도 내가 지운 항목이 삭제되어 있음. 

