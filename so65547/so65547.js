const board_preference = {0: "＋", 1: "○", 2: "●", 3: "■", 4: "＋"};
let board = 
[[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,4,3,0,0,0],
[0,0,4,1,2,3,0,0],
[0,0,3,2,1,4,0,0],
[0,0,0,3,4,0,0,0],
[0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0]];

const user_turn = (user_selection_vertical, user_selection_horizontal) => {
    var user_x = user_selection_vertical;
    var user_y = user_selection_horizontal;
    if (board[user_x][user_y] == 3) {
        board[user_selection_vertical][user_selection_horizontal] = 1;
    }
    let user_turn_flag = true;
    let user_turn_count = 0;
    while (user_turn_flag) {
        if (!user_x + user_turn_count == 0) {
            if (board[user_x - user_turn_count][user_y] == 2&&board[user_x - (user_turn_count + 1)][user_y] == 1) {
                changehost(user_x - user_turn_count,user_y,1);
            }
        }
        if (!user_x + user_turn_count == 7) {
            if (board[user_x + user_turn_count][user_y] == 2&&board[user_x +(user_turn_count + 1)][user_y] == 1) {
                changehost(user_x - user_turn_count,user_y,1);
            }
        }
        if (!user_y + user_turn_count == 0) {
            if (board[user_x][user_y - user_turn_count] == 2&&board[user_x][user_y - (user_turn_count + 1)] == 1) {
                changehost(user_x - user_turn_count,user_y,1);
            }   
        }
        if (!user_y + user_turn_count == 7) {
            if (board[user_x][user_y + user_turn_count] == 2&&board[user_x][user_y + (user_turn_count + 1)] == 1) {
                changehost(user_x - user_turn_count,user_y,1);
            }
        }
        if (user_turn_count == 7) {user_turn_flag = false;}
        user_turn_count++;
    }
}

const changehost = (host_selection_vertical, host_selection_horizontal,Human) => {
    let host_x = host_selection_vertical;
    let host_y = host_selection_horizontal;
    board[host_x][host_y] = Human;
}
user_turn(4,2);
console.log(board_display());
