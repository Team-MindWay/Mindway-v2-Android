package com.chobo.domain.exception

import java.io.IOException

class RequestLoginException: IOException() {
    override val message: String
        get() = "토큰이 만료가 되었습니다.. 다시 로그인 해주세요."
}