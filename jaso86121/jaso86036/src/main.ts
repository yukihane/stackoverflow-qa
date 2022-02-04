type valueType = 'foo_1' | 'foo_2';

const prefix = ( value: string ): string => {
    const prefix = 'foo';
    return `${prefix}_${value}`;
}

const process = (): valueType => {
    if ( /* 省略 */ ) {
        return prefix('1');
    } else {
        return prefix('2');
    }
}
