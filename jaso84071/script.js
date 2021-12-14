function submit() {
  discord();
}

// channel を key にした map を返すように変更
function get_value() {
  var sheet1 = SpreadsheetApp.getActive().getSheetByName("Sheet1");

  var [[date], [format]] = sheet1.getRange("C2:C3").getValues();
  format = format.replace(/[ 　"+]+/g, "").replace("date", date);
  // C列(discord名前/channel) を含める
  var values = sheet1.getRange("C11:R" + sheet1.getLastRow()).getValues();
  var messages_array = values
    .filter((r) => r[2] != 0)
    .map(
      ([
        channel,
        allpoint,
        ,
        haisintime,
        haisinkaisu,
        ,
        ,
        ,
        ,
        ,
        ,
        ,
        ,
        ,
        ,
        comrank,
      ]) => {
        const message = Object.entries({
          allpoint,
          haisintime,
          haisinkaisu,
          comrank,
        }).reduce((s, e) => s.replace(...e).replace(/\\n/g, "\n"), format);

        return [channel, message];
      }
    );

  return new Map(messages_array);
  // // 参考: V8 が OFF の場合
  // // https://officeforest.org/wp/2020/02/06/google-apps-script%E3%81%AEv8-runtime%E5%AF%BE%E5%BF%9C%E3%82%92%E6%A4%9C%E8%A8%BC%E3%81%97%E3%81%A6%E3%81%BF%E3%81%9F/#Map
  // // https://stackoverflow.com/a/26265095/4506703
  //   return messages_array.reduce(function (map, obj) {
  //     map[obj[0]] = obj[1];
  //     return map;
  //   }, {});
}

//googleスプレットシート  自動送信
function get_sheet(gss_url, sheet_num) {
  var ss = SpreadsheetApp.openByUrl(gss_url);
  var sheet = ss.getSheets()[sheet_num];
  return sheet;
}

function get_sheet2(gss_url, sheet_num) {
  return SpreadsheetApp.getActive().getSheetByName("Sheet2");
}

function discord(message) {
  var sheet2 = get_sheet2(
    "https://docs.google.com/spreadsheets/d/yyyyyyyyyyyyyyyy",
    0
  );

  var messages = get_value(); // call get_value() at here

  var lastRow2 = sheet2.getLastRow(); //最終行取得

  for (let j = 11; j <= lastRow2; j++) {
    //webhook
    var webhookcoord = sheet2.getRange(j, 3);
    var webhook = webhookcoord.getValue();

    //token
    var tokencoord = sheet2.getRange(j, 4);
    var dtoken = tokencoord.getValue(); //channel

    var channelcoord = sheet2.getRange(j, 2);
    var dchannel = channelcoord.getValue();

    //format
    const url = webhook;
    const token = dtoken;
    const channel = dchannel;
    const text = messages[j - 11];
    if (text === "None") {
      console.log(channel + " : 送信なし");
      continue;
    }

    const username = "〇〇〇";
    const avatar_url = "http://drive.google.com/uc?export/aaaaaaaaaaaaaaaaaaa";
    const parse = "full";
    const method = "post";

    const payload = {
      token: token,
      channel: channel,
      content: text,
      username: username,
      parse: parse,
      avatar_url: avatar_url,
    };

    const params = {
      method: method,
      payload: payload,
      muteHttpExceptions: true,
    };
    Utilities.sleep(500);

    // response = UrlFetchApp.fetch(url, params);
    //実行ログ
    console.log(channel + " : " + text);
  }
}
