# 第五週 AI 使用紀錄

| 欄位 | 本人紀錄 |
|---|---|
| 使用工具／方式 | 使用 ChatGPT（OpenAI）協助 Java 作業。 |
| 目的與提問摘要 | 請 AI 協助理解第五週作業要求、完成 MissionStep.java 與 MissionLog.java，並排除編譯及測試問題。 |
| 建議與本人處理 | 參考 AI 提供的程式碼，完成任務紀錄、歷程回放及統計功能。測試時發現結果名稱與老師預期不同，依照規格修改 ALREADY_FULL 與 UNKNOWN_COMMAND，並保留其他程式邏輯。 |
| 本人實際驗證 | 使用 VS Code 終端機執行 javac 編譯及 java 執行。測試 `{1,1,2}`，結果為 energy=6、samples=5、actionCount=3、SUCCESS；測試 `{3,9,0}`，結果為 energy=20、samples=0、actionCount=0、RETURNED。兩組輸出均符合預期。 |