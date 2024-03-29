#![cfg_attr(
    all(not(debug_assertions), target_os = "windows"),
    windows_subsystem = "windows"
)]

use rss::Channel;
use std::error::Error;

struct StateValue(String);

async fn example_feed() -> Result<Channel, Box<dyn Error>> {
    let content = reqwest::get("https://www.soumu.go.jp/news.rdf")
        .await?
        .bytes()
        .await?;
    let channel = Channel::read_from(&content[..])?;
    Ok(channel)
}

#[tauri::command]
async fn get_rss(_state: tauri::State<'_, StateValue>) -> Result<String, ()> {
    let a: Result<Channel, Box<dyn Error>> = example_feed().await;
    match a {
        Ok(result) => {
            println!("{:?}", result);
        }
        Err(msg) => {
            println!("No");
        }
    }

    Ok(String::from("test"))
}

// 別解
// #[tauri::command]
// async fn get_rss() -> String {
//     let a: Result<Channel, Box<dyn Error>> = example_feed().await;
//     match a {
//         Ok(result) => {
//             println!("{:?}", result);
//         }
//         Err(msg) => {
//             println!("No");
//         }
//     }

//     String::from("test")
// }

fn main() {
    tauri::Builder::default()
        .manage(StateValue("some state value".into()))
        .invoke_handler(tauri::generate_handler![get_rss])
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
