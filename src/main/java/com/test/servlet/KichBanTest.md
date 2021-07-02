# Kịch bản demo BIO và NIO:
    - WEb server chỉ seting 1 thread xử lý duy nhất.
    - Cấu hình timeout reuqest 20s

## Kịch bản test BIO: (org.apache.coyote.http11.Http11Protocol)
     - Sử dụng class TestNotAsyncSupport: sau khi browser A request sẽ chờ 5s để sử lý và trả về thành công.
     - Ngay sau đó browser B reqeust, sẽ bị chặn không gọi được.
## Kịch bản test NIO: (org.apache.coyote.http11.Http11NioProtocol )
     - Sử dụng class TestNotAsyncSupport: sau khi browser A request sẽ chờ 5s để sử lý và trả về thành công.
     - Ngay sau đó browser B reqeust hành động được thực hiện

#Kịch bản DEMO async servlet
    - WEb server chỉ seting 1 thread xử lý duy nhất.
    - Cấu hình chạy NIO (org.apache.coyote.http11.Http11NioProtocol )
    - Sử dụng TestAsyncSupport bên trong sử dụng Async.
    - Client A request chưa có reponse, client B tiếp tục request --> Sv vẫn nhận reqeust của client B và sử lý reqeust đó
