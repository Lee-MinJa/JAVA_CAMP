import React, { useState } from "react";
import ReactQuill from "react-quill";
import EditorToolbar, { modules, formats } from "./EditorToolbar";
import "react-quill/dist/quill.snow.css";
import "./styles.css";

export const BoardEditor = () => {
  const [state, setState] = useState({ value: null });
  const handleChange = value => {
    setState({ value });
    console.log(state)
  };

  
  return (
    <div className="text-editor">
      <EditorToolbar />
      <ReactQuill
        theme="snow"
        spellcheck={false}
        value={state.value}
        onChange={handleChange}
        placeholder={"Hi.Camping 약관 규정상 적절하지 않은 내용을 게시할 경우 통보없이 삭제될 수 있음을 안내드립니다."}
        modules={modules}
        formats={formats}
      />
    </div>
  );
};

export default BoardEditor;
