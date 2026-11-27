\# Week 08 — 系統設計



\## 類別關係



\- HeavyRover is-a Rover

\- SurveyRover is-a Rover

\- Mission has-a Rover



\## 方法覆寫



Rover 保留 private explore()，透過 protected exploreYield() 決定探索產量。



HeavyRover 覆寫 exploreYield()，回傳 3，並覆寫 execute() 支援鑽探指令 4。



SurveyRover 覆寫 exploreYield()，回傳 1，代表精細採樣車。



\## 設計理由



透過繼承及方法覆寫保留父類別的能源管理、行動計次與任務停止規則，避免重複撰寫相同程式。



Mission 使用 Rover 型態參考，因此不需要依照不同車種修改任務流程。



\## 自訂子類別測試



| 案例 | 能源 | 樣本 | 行動次數 | 結果 |

|---|---:|---:|---:|---|

| 正常任務 | 6 | 3 | 3 | 任務未完成 |

| 能源剛好足夠 | 0 | 5 | 1 | 任務成功 |

| 能源不足 | 5 | 0 | 0 | 能源不足 |

| 任務已停止 | 20 | 5 | 0 | 任務已停止 |

| 一般車反例 | 14 | 5 | 1 | 任務成功 |

| 精細採樣車反例 | 12 | 5 | 2 | 任務成功 |



\## UML 類別圖



!\[UML 類別圖](diagrams/dispatch\_practice.svg)



目前 PlantUML 原始檔已建立，SVG 尚待匯出。

