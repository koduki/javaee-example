# Jakarta EE サンプルプロジェクト

エンタープライズJava開発のベストプラクティスと一般的なパターンを示す包括的なJakarta EE 10 Webアプリケーションです。

## 概要

このプロジェクトは、RESTful Webサービス、JPA永続化、カスタムバリデーション、包括的なロギングを備えた最新のJakarta EE 10アプリケーションを紹介します。エンタープライズJava Webアプリケーションを構築するための学習リソースおよびリファレンス実装として設計されています。

## 機能

- **RESTful API**: ユーザー管理のためのJAX-RS 3.1ベースのRESTエンドポイント
- **JPA/EclipseLink**: JPA 3.1とEclipseLink 4.0によるエンティティの永続化
- **Bean Validation**: クロスフィールドバリデーションを含むカスタムバリデーター
- **CDI**: Context and Dependency Injection 4.0による依存性注入
- **ロギング**: Log4j2 2.24.2による構造化ロギング
- **Lombok**: Lombok 1.18.36アノテーションによるボイラープレートの削減
- **カスタムアノテーション**: @TimeLogや@ErrorLogなどの再利用可能なアスペクト
- **アクセスログ**: HTTPリクエスト/レスポンスのロギングフィルター

## 技術スタック

- Java 17 (LTS)
- Jakarta EE 10 (Web Profile)
- Maven 3.6+
- JPA 3.1 (EclipseLink 4.0)
- JAX-RS 3.1
- CDI 4.0
- Bean Validation 3.0
- Log4j2 2.24.2
- Lombok 1.18.36
- JUnit 5 (Jupiter)

## プロジェクト構造

```
src/main/java/
├── pascal/orz/cn/example/javaee/
    ├── apps/
    │   ├── model/          # JPAエンティティとDAO
    │   └── resources/      # REST APIエンドポイント
    └── commons/
        ├── annotations/    # カスタムアノテーション
        ├── filters/        # サーブレットフィルター
        ├── utils/          # ユーティリティクラス
        └── validators/     # カスタムバリデーター
```

## はじめに

### 前提条件

- JDK 17以上
- Maven 3.6+
- Jakarta EE 10互換のアプリケーションサーバー（例：GlassFish 7+、WildFly 27+、Payara 6+）

### プロジェクトのビルド

```bash
mvn clean compile
```

### テストの実行

```bash
mvn test
```

### パッケージング

```bash
mvn package
```

これにより、`target/`ディレクトリにWARファイルが作成され、任意のJakarta EE 10互換サーバーにデプロイできます。

## APIエンドポイント

### Users API

- `GET /api/users` - 全ユーザーの一覧を取得
- `POST /api/users` - 新しいユーザーを作成

リクエスト例：
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "age": 30
}
```

## カスタムバリデーター

### @FirstOrLastRequired

firstNameまたはlastNameのいずれかが提供されていることを保証するクロスフィールドバリデーター：

```java
@FirstOrLastRequired
public class Users {
    private String firstName;
    private String lastName;
    // ...
}
```

## 設定

- `src/main/resources/META-INF/persistence.xml` - JPA設定
- `src/main/resources/log4j2.xml` - ロギング設定
- `src/main/webapp/WEB-INF/web.xml` - Webアプリケーション設定

## 作者

koduki

## コントリビューション

コントリビューションを歓迎します！お気軽にプルリクエストを送ってください。

## ライセンス

このプロジェクトはMITライセンスの下でライセンスされています。詳細はLICENSEファイルを参照してください。
