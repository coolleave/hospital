import request from '@/utils/request'

// 查询格拉斯哥昏迷评分列表
export function listGcsscore(query) {
  return request({
    url: '/system/Gcsscore/list',
    method: 'get',
    params: query
  })
}

// 查询格拉斯哥昏迷评分详细
export function getGcsscore(Id) {
  return request({
    url: '/system/Gcsscore/' + Id,
    method: 'get'
  })
}

// 新增格拉斯哥昏迷评分
export function addGcsscore(data) {
  return request({
    url: '/system/Gcsscore',
    method: 'post',
    data: data
  })
}

// 修改格拉斯哥昏迷评分
export function updateGcsscore(data) {
  return request({
    url: '/system/Gcsscore',
    method: 'put',
    data: data
  })
}

// 删除格拉斯哥昏迷评分
export function delGcsscore(Id) {
  return request({
    url: '/system/Gcsscore/' + Id,
    method: 'delete'
  })
}
export function listGcsscoreByEncounterId(encounterId) {
  return request({
    url: '/system/Gcsscore/list2',
    method: 'get',
    params: { encounterId }
  })
}