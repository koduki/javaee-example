# JavaEE サンプルプロジェクト

エンタープライズJava開発のベストプラクティスと一般的なパターンを示す包括的なJavaEE 7 Webアプリケーションです。

## 概要

このプロジェクトは、RESTful Webサービス、JPA永続化、カスタムバリデーション、包括的なロギングを備えた最新のJavaEE 7アプリケーションを紹介します。エンタープライズJava Webアプリケーションを構築するための学習リソースおよびリファレンス実装として設計されています。

## 機能

- **RESTful API**: ユーザー管理のためのJAX-RSベースのRESTエンドポイント
- **JPA/EclipseLink**: JPA 2.1とEclipseLinkによるエンティティの永続化
- **Bean Validation**: クロスフィールドバリデーションを含むカスタムバリデーター
- **CDI**: Context and Dependency Injectionによる依存性注入
- **ロギング**: Log4j2による構造化ロギング
- **Lombok**: Lombokアノテーションによるボイラープレートの削減
- **カスタムアノテーション**: @TimeLogや@ErrorLogなどの再利用可能なアスペクト
- **アクセスログ**: HTTPリクエスト/レスポンスのロギングフィルター

## 技術スタック

- Java 8
- JavaEE 7 (Web Profile)
- Maven 3.6+
- JPA 2.1 (EclipseLink 2.5)
- JAX-RS 2.0
- CDI 1.1
- Bean Validation 1.1
- Log4j2 2.0
- Lombok 1.18.30
- JUnit 4.11

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

- JDK 8以上
- Maven 3.6+
- JavaEE 7互換のアプリケーションサーバー（例：GlassFish 4.0+、WildFly 8+、Payara 4+）

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

これにより、`target/`ディレクトリにWARファイルが作成され、任意のJavaEE 7互換サーバーにデプロイできます。

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
