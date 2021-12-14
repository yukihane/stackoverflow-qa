function submit() {
  discord();
}

function get_value() {
  var sheet1 = SpreadsheetApp.getActiveSheet();

  var [[date], [format]] = sheet1.getRange("C2:C3").getValues();
  format = format.replace(/[ 　"+]+/g, "").replace("date", date);
  var values = sheet1.getRange("D11:R" + sheet1.getLastRow()).getValues();
  var messages_array = values
    .filter((r) => r[2] != 0)
    .map(([allpoint, , haisintime, haisinkaisu, , , , , , , , , , , comrank]) =>
      Object.entries({ allpoint, haisintime, haisinkaisu, comrank }).reduce(
        (s, e) => s.replace(...e).replace(/\\n/g, "\n"),
        format
      )
    );
  return messages_array;
}

//googleスプレットシート  自動送信
function get_sheet(gss_url, sheet_num) {
  var ss = SpreadsheetApp.openByUrl(gss_url);
  var sheet = ss.getSheets()[sheet_num];
  return sheet;
}

function get_sheet2(gss_url, sheet_num) {
  var discord = SpreadsheetApp.openByUrl(gss_url);
  var sheet2 = discord.getSheets()[sheet_num];
  return sheet2;
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

    response = UrlFetchApp.fetch(url, params);
    //実行ログ
    console.log(channel + " : " + text);
  }
}
