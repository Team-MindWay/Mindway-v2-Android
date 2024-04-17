package com.chobo.data.util.excption

class BadRequestException( // 400: 올바르지 않은 요청
    override val message: String?
) : RuntimeException()


class UnauthorizedException( // 401: 비인증 상태
    override val message: String?
) : RuntimeException()


class ForBiddenException( // 403: 권한이 없음
    override val message: String?
) : RuntimeException()


class NotFoundException( // 404: 요청한 리소스를 찾을 수 없음
    override val message: String?
) : RuntimeException()

class TimeOutException( // 408: 요청시간초과
    override val message: String?
) : RuntimeException()

class ConflictException( // 409: 충돌발생
    override val message: String?
) : RuntimeException()

class ServerException( // 50X: 서버에러
    override val message: String?
) : RuntimeException()

class OtherHttpException( // 정의되지 않은 HTTP 상태 코드나 사용자 정의 상태 코드
    val code: Int,
    override val message: String?
) : RuntimeException()

class UnKnownException( // 알려지지 않은 에러
    override val message: String?
) : RuntimeException()