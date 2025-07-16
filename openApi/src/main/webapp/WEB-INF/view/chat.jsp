<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>OpenAI Chat UI (Ajax)</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 h-screen flex flex-col">

  <header class="bg-white p-4 shadow text-xl text-center font-semibold">
    OpenAI Chat (현재 세션 : ${sessionId}) <a href="/reset">[세션 초기화]</a>
  </header>

  <main id="chat-box" class="flex-1 overflow-y-auto p-4 space-y-4">
  	<c:if test="${chatList != null}">
  		<c:forEach	items="${chatList}" var="c">
  			<div class="text-right">
	          <div class="inline-block bg-blue-200 rounded-lg px-4 py-2 max-w-md">
	            ${c.userMsg}
	          </div>
	        </div>
  		
  			<div class="text-left">
	          <div class="inline-block bg-gray-200 rounded-lg px-4 py-2 max-w-md">
	            ${c.aiReply}
	          </div>
	        </div>
  		</c:forEach>
  	</c:if>
  </main>

  <form id="chat-form" class="bg-white p-4 flex gap-2 shadow">
    <input
      type="text"
      id="message"
      placeholder="메시지를 입력하세요..."
      class="flex-1 px-4 py-2 border rounded-lg"
      required
    />
    <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded-lg">전송</button>
  </form>

  <script>
    const chatBox = $('#chat-box');

    function addMessage(role, content) {
      const alignment = role === 'user' ? 'text-right' : 'text-left';
      const bubbleColor = role === 'user' ? 'bg-blue-200' : 'bg-gray-200';
      const html = `
        <div class="${alignment}">
          <div class="inline-block ${bubbleColor} rounded-lg px-4 py-2 max-w-md">
            ${content}
          </div>
        </div>`;
      chatBox.append(html);
      chatBox.scrollTop(chatBox[0].scrollHeight);
    }

    $('#chat-form').on('submit', function (e) {
      e.preventDefault();
      const userMessage = $('#message').val().trim();
      if (!userMessage) return;

      addMessage('user', userMessage);
      $('#message').val('');

      $.ajax({
        url: '/chat',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ "userMsg" : userMessage }),
        success: function (res) {
          //addMessage('ai', res);
          window.location.href = '/chat';
        },
        error: function () {
          addMessage('ai', '⚠️ 오류가 발생했습니다.');
        }
      });
    });
  </script>

</body>
</html>