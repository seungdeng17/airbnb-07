const MAIN = {
    LOCATION: {
        DEFAULT_LOCATION: 'Seattle',
    },
    DATE: {
        START_DATE_ID: 'airbnb-start-date',
        END_DATE_ID: 'airbnb-end-date',
    },
    PERSON: {
        LIMIT_COUNT: 8,
        ADULT: {
            TEXT: '어른',
            DESC: '만 13세 이상',
            COUNT_TYPE: { countType: 'adultCount' },
        },
        CHILD: {
            TEXT: '어린이',
            DESC: '2 ~ 12세',
            COUNT_TYPE: { countType: 'childCount' },
        },
        BABY: {
            TEXT: '유아',
            DESC: '2세 미만',
            COUNT_TYPE: { countType: 'babyCount' },
        },
    },
    ROOMS: {
        MAXIMUM_VIEW_ITEM_COUNT: 12,
    },
    CHARGE: {
        MIN_CHARGE: 10000,
        MAX_CHARGE: 1000000,
    },
    RESERVATION: {
        CLEAN_UP_COST: 15000,
        SERVICE_COST: 2000,
        TAX_RATE: 0.05,
    },
    PAGE: {
        DEFAULT_PAGE: 1,
    }
}

const COMMON = {
    TOKEN_KEY: 'token',
    INIT_ROOMS_DATA_KEY: 'init_rooms',
    FILTER_DATA_KEY: 'filter_data',
    FILTER_ROOMS_DATA_KEY: 'filter_rooms',
    RESERVATION_INFO_DATA_KEY: 'reservation_info',
    LOADING: '잠시 기다려 주세요.',
    NOT_LOGIN_MEASSAGE: '로그인 정보가 없습니다. 로그인 페이지로 이동합니다.',
    NOT_ENOUGH_CONDITION_MESSAGE: '날짜와 인원을 선택하세요.',
    NOT_INPUT_CHECKOUT_MESSAGE: '체크아웃 날짜를 선택하세요.',
    GET_DATA_ERROR: '조회에 실패했습니다. 다시 시도해주세요.',
    NOT_RESULT: '검색 결과가 없습니다.',
}

export {
    MAIN,
    COMMON
}