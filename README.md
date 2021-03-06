# B18-Wallet

# SetUpManual

## 概要

ここではJDKのインストールされた仮想サーバがあるものとし,そのサーバへのアクセス方法およびサーバ上でのアプリの実行方法について説明します.  

## 操作方法

### サーバへのアクセス

サーバへのアクセスはSSHを利用します.今回使用するサーバは学内ネットワーク上にあるため,接続の際にはVPNを利用してください.  
今回使用するサーバのIPアドレスは**150.89.233.208**です.  
アクセスには**isdev-bash-2.28.0-64.exe**を起動後,以下のコマンドを入力してください.  

```
ssh isdev20@150.89.233.208
```
その後,パスワードを要求されるので「**isDev20?208**」と入力し,サーバへアクセスしてください.  

### リポジトリのクローン

続いてリポジトリのクローンを行います.  
まずは,ホームディレクトリへ移動します.以下のコマンドを入力し,ホームディレクトリへ移動してください.  

```
cd
```

次に,pwdコマンドを用いてホームディレクトリに移動できているか確認を行います.コマンド実行後,以下のように表示されていることを確認してください.  

```
isdev20@ubuntu 20 8:~$ pwd
/home/isdev
```

ホームディレクトリに移動できたら,リポジトリのクローンを行います.以下のコマンドを実行してクローンを行ってください.  

```
git clone https://github.com/e1b18051/B18-Wallet.git
```

正しくリポジトリのクローンができているかlsコマンドを使用して確認を行います.  
コマンド実行後,以下のように表示されていることを確認してください.  
**B18-Wallet**はリポジトリ名です.  

```
isdev20@ubuntu 208:~$ ls

B18-Wallet
```

### アプリケーションの実行

リポジトリのクローンができたら,まずcdコマンドを利用してリポジトリに移動します.  

```
cd B18-Wallet
```

その後,アプリケーションの実行を行います.まずは,以下のように chmod コマンドを利用して,gradlewの実行権限を与えます.  

```
chmod 755 gradlew
```

gradlewの実行権限を与えたら,以下のコマンドを利用してgradlewの実行を行ってください.  

```
sh gradlew
```
コマンドを実行後,以下のように表示されることを確認してください.（参考例です）  

```
---(前略)---
BUILD SUCCESSFUL in 22s

1 actionable task: 1 executed
```

最後に,プロジェクトの実行を行うため,以下のコマンドを実行してください.  

```
./gradlew bootrun
```

実行後,ブラウザで http://150.89.233.208:8080/ にアクセスしてください.  
アクセス後,ユーザマニュアルに従ってアプリケーションが動作することを確認してください.  

### アプリケーションの常時実行について

アプリケーションの常時実行には以下のコマンドを利用してください.  

```
nohup bash ./gradlew bootrun > log.txt 2> errors.txt < /dev/null &

PID=$!

echo $PID > pid.txt
```

常時実行を止める場合は以下のコマンドを使用してください.  

```
PID=$(cat pid.txt)

kill $PID
```

---

# UserManual

## アプリの概要

本アプリは複数のユーザ間で収入,支出の共有を行える家計簿アプリです.  
各ユーザは収入,支出のデータの入力ができるほか,入力された全データの確認が行えます.また,確認画面では入力されたデータの編集や削除,日付での絞り込みが行え,収入や支出の総額なども確認できます.  
さらに,確認画面に表示される収入と支出のデータはすべて非同期で更新されるようになっています.例えば,ユーザAとBがログインしているとき,Aが確認画面でデータの編集や削除を行った場合,Bの確認画面でもAの更新が非同期で反映されるようになっています.また,Aが収入もしくは支出のデータの追加を行った場合にも,Bの確認画面でAの更新が非同期で反映されるようになっています.  

## 動作環境

・PC,スマホ対応  
・対応ブラウザ(Google Chrome, Firefox, Microsoft Edge, Safari)  

## 操作説明

### ・ログイン

|![index](https://user-images.githubusercontent.com/56813109/104848302-b201ef80-5927-11eb-9dbb-4455918f73ef.jpg "index.htmlの画面")|
|:-:|

http://150.89.233.208:8080/ にアクセスすると上記ページが表示されます.「ログイン」をクリックし,ログインフォームに移動してください.  

|![login_form](https://user-images.githubusercontent.com/56813109/104848331-d1008180-5927-11eb-9f68-7184fa7ac07a.jpg "ログインフォームの画面")|
|:-:|

ログインフォームは上記ページのように表示されます.ここでユーザネームとパスワードを入力し,ログインしてください.  
ログインには以下の2つを使用してください.  
　ユーザネーム:user1  
　パスワード:pAssw0rd  
もしくは  
　ユーザネーム:user2  
　パスワード:pAssw0rd  

### ・ホーム画面での操作

|![home](https://user-images.githubusercontent.com/56813109/104848346-e37abb00-5927-11eb-8beb-5607da77cc4b.jpg "home.htmlの画面")|
|:-:|

ログイン後,上記ページに遷移します.このページでは,画像アイコンをクリックすることで各ページへの遷移が行えます.  
収入の追加を行う場合は収入のアイコンを,支出の追加を行う場合は支出のアイコンを,データの確認を行う場合は確認のアイコンをクリックしてください.  

### ・データの追加

|![income](https://user-images.githubusercontent.com/56813109/104848370-fc836c00-5927-11eb-8363-750e7524ae9b.jpg "income.htmlの画面")|
|:-:|

|![spend](https://user-images.githubusercontent.com/56813109/104848387-102ed280-5928-11eb-80db-22b9cd6d99fc.jpg "spend.htmlの画面")|
|:-:|

ホーム画面で収入もしくは支出のアイコンをクリックすると,上記ページに遷移します.  
これらのページでは,収入および支出の追加が行えます.  
データの追加では,収入および支出のあった日付とその金額,メモの入力ができます.  
日付欄では,カレンダーマークをクリックすることでカレンダーから日付を直接選択することができ,メモ欄では自由に書き込みをすることができます.  
また,データの追加では日付および金額の入力が必須となっています.  

### ・データの確認

|![check](https://user-images.githubusercontent.com/56813109/104848399-1e7cee80-5928-11eb-911b-804a5aff64ae.jpg "check.htmlの画面")|
|:-:|

ホーム画面で確認のアイコンをクリックすると,上記ページに遷移します.  
収入および支出の全データが表示されており,これらの合計金額およびその差額がページ上部に表示されています.  
また,確認ページではデータの確認だけでなく以下の3つが行えます.  
　・データの絞り込み  
　・データの編集  
　・データの削除  

### ・データの絞り込み

|![check_DateRef](https://user-images.githubusercontent.com/56813109/104848411-35234580-5928-11eb-9df7-9ca9a681d93e.jpg "check.htmlの絞り込み後の画面")|
|:-:|

確認ページで絞り込みを行うと上記ページのように表示されます.  
絞り込みは年月日で行います.ページ上部にある日付入力欄で年月日を指定すると絞り込みが行えます.  
また,全データ表示ボタンを押すと絞り込みを解除することができます.  

### ・データの編集

|![check_Update_Form](https://user-images.githubusercontent.com/56813109/104848432-4409f800-5928-11eb-8126-bc71cf99e35e.jpg "check.htmlの編集フォームの画面")|
|:-:|

確認ページの編集ボタンをクリックすると該当データの編集を行うことができます.  
上記ページは編集ボタンのクリック後の画像です.ページ下部にデータの内容が初期値として格納された編集フォームが表示され,データの編集を行うことができます.  
また,データの追加時と同様に日付と金額の入力が必須となっています.  

### ・データの削除

|![check_Delete](https://user-images.githubusercontent.com/56813109/104848447-5c7a1280-5928-11eb-8394-898f72bba498.jpg "heck.htmlの削除後の画面")|
|:-:|

確認ページの削除ボタンをクリックすると該当データの削除が行えます.  
上記ページは削除ボタンのクリック後の参考画像です.  

### ・ログアウト

ログアウトは各ページでいつでも行うことができます.画面右上の「ログアウト」をクリックしてログアウトしてください.  

## 注意事項

・確認画面上で全データ表示や再読み込みを連続で何度も行わないでください.  
　非同期で表示させているためエラーが発生してサーバー自体の再起動を行わなければならなくなります.  
