#include <stdio.h>
#include <stdlib.h>

char* greet(char *name) {
	char *message = calloc(256, sizeof(char));
	sprintf(message, "こんにちは、%s！", name);

	return message;
}

void greet_retval_dtor(char *retval) {
	free(retval);
}

void greet_prepared_buffer(char *name, char *message) {
	sprintf(message, "こんにちは、%s！", name);
}

void greet_callback(char *name, void (*cb)(char *message)) {
	char *message = calloc(256, sizeof(char));

	sprintf(message, "こんにちは、%s！", name);
	cb(message);

	free(message);
}

void callback(char *message) {
	printf("%s\n", message);
}

int main(int argc, char **argv) {
	char *message = greet("世界");
	printf("%s\n", message);

	char *buff = calloc(256, sizeof(char));
	greet_prepared_buffer("バッファ", buff);
	printf("%s\n", buff);
	free(buff);

	greet_callback("コールバック", callback);

	char *message2 = greet("デストラクタ");
	printf("%s\n", message2);
	greet_retval_dtor(message2);

	return 0;
}

