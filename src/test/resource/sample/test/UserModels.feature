Feature: ユーザModels

    Scenario: ユーザ名を指定して登録する
        Given   ユーザ名 'tajima'
        When    ユーザを登録する
        Then    ユーザ名のみのオブジェクトが登録されること
            """
            {"name":"tajima","projects":[]}
            """

    Scenario: お気に入りプロジェクトとユーザ名を指定してインスタンスを生成する
        Given   ユーザ名 'tajima'
        And     お気に入りプロジェクト名 'elasticsearch' URL 'https://github.com/elasticsearch/elasticsearch'
        When    ユーザを登録する
        Then    ユーザ名とプロジェクト名を保持してオブジェクトが登録されること
            """
            {"name":"tajima","projects":[{"name":"elasticsearch"},{"url":"https://github.com/elasticsearch/elasticsearch"}]}
            """

